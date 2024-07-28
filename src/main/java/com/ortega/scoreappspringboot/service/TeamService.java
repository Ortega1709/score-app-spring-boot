package com.ortega.scoreappspringboot.service;

import com.ortega.scoreappspringboot.model.Team;
import com.ortega.scoreappspringboot.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

  @Autowired
  private TeamRepository teamRepository;

  public List<Team> getAllTeams(){
      return teamRepository.findAll();
  }

  public Optional<Team> getTeamById(String id) {
      return teamRepository.findById(id);
  }

  public Team saveTeam(Team team) {
      return teamRepository.save(team);
  }

  public List<Team> saveTeams(List<Team> teams) {
      return teamRepository.saveAll(teams);
  }

  public Team updateTeam(Team team) {
      return teamRepository.save(team);
  }

  public void deleteTeam(String id) {
      teamRepository.deleteById(id);
  }

}
