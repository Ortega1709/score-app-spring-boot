package com.ortega.scoreappspringboot.service;

import com.ortega.scoreappspringboot.model.Subscription;
import com.ortega.scoreappspringboot.model.Team;
import com.ortega.scoreappspringboot.model.User;
import com.ortega.scoreappspringboot.repository.SubscriptionRepository;
import com.ortega.scoreappspringboot.repository.TeamRepository;
import com.ortega.scoreappspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TeamRepository teamRepository;

    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    public Subscription subscribe(String userId, String teamId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Team team = teamRepository.findById(teamId).orElseThrow(() -> new RuntimeException("Team not found"));

        Subscription subscription = new Subscription();
        subscription.setUser(user);
        subscription.setTeam(team);

        return subscriptionRepository.save(subscription);
    }

    public Subscription getSubscriptionById(String subscriptionId) {
        return subscriptionRepository.findById(subscriptionId).orElseThrow(() -> new RuntimeException("Subscription not found"));
    }

    public List<Subscription> getSubscriptionsByUserId(String userId) {
        return subscriptionRepository.findByUserId(userId);
    }

    public List<Subscription> getSubscriptionsByTeamId(String teamId) {
        return subscriptionRepository.findByTeamId(teamId);
    }

    public void deleteSubscription(String subscriptionId) {
        if (subscriptionRepository.existsById(subscriptionId)) {
            subscriptionRepository.deleteById(subscriptionId);
        }
    }

}
