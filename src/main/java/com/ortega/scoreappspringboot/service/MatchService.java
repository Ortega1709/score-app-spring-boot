package com.ortega.scoreappspringboot.service;

import com.ortega.scoreappspringboot.model.*;
import com.ortega.scoreappspringboot.repository.GoalRepository;
import com.ortega.scoreappspringboot.repository.MatchRepository;
import com.ortega.scoreappspringboot.repository.SubscriptionRepository;
import com.ortega.scoreappspringboot.repository.TeamRepository;
import com.ortega.scoreappspringboot.request.CreateMatchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private SubscriptionRepository subscriptionRepository;
    @Autowired
    private GoalRepository goalRepository;

    public Match save(CreateMatchRequest request) {
        if (!Objects.equals(request.getTeamA(), request.getTeamB())) {
            Optional<Team> teamA = teamRepository.findById(request.getTeamA());
            Optional<Team> teamB = teamRepository.findById(request.getTeamB());
            if (teamA.isPresent() && teamB.isPresent()) {
                Match match = new Match();
                match.setTeamA(teamA.get());
                match.setTeamB(teamB.get());
                match.setStatus("upcoming");

                return matchRepository.save(match);
            }
        }
        return null;
    }

    public Match findById(String id) {
        Optional<Match> matchOptional = matchRepository.findById(id);
        if (matchOptional.isPresent()) {
            Match match = matchOptional.get();
            Optional<List<Goal>> goalOptional = goalRepository.findGoalsByMatch(match);
            goalOptional.ifPresent(match::setGoals);
        }
        return matchRepository.findById(id).orElse(null);
    }

    public List<Match> findAllMatchesByUserSubscribed(String userId) {
        List<Subscription> subscriptions = subscriptionRepository.findByUserId(userId);

        List<Team> subscribedTeams = subscriptions.stream()
                .map(Subscription::getTeam)
                .toList();

        Set<Match> matches = new HashSet<>();
        for (Team team : subscribedTeams) {
            List<Match> teamMatches = matchRepository.findByTeamAOrTeamB(team, team);
            matches.addAll(teamMatches);
        }

        return new ArrayList<>(matches);
    }

    public List<Match> findAll() {
        return matchRepository.findAll();
    }

    public void addGoal(Score score) {
        Optional<Match> matchOptional = matchRepository.findById(score.getMatch());
        if (matchOptional.isPresent()) {
            Match match = matchOptional.get();
            Goal goal = new Goal();

            goal.setMatch(match);
            goal.setScoreA(score.getScoreA());
            goal.setScoreB(score.getScoreB());

            goalRepository.save(goal);
        }
    }

}
