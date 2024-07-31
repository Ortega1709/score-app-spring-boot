package com.ortega.scoreappspringboot.service;

import com.ortega.scoreappspringboot.model.Subscription;
import com.ortega.scoreappspringboot.model.Team;
import com.ortega.scoreappspringboot.model.User;
import com.ortega.scoreappspringboot.repository.SubscriptionRepository;
import com.ortega.scoreappspringboot.repository.TeamRepository;
import com.ortega.scoreappspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
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
        if (!subscriptionRepository.existsByUserIdAndTeamId(userId, teamId)) {
            Optional<User> userOptional = userRepository.findById(userId);
            Optional<Team> teamOptional = teamRepository.findById(teamId);

            if (userOptional.isPresent() && teamOptional.isPresent()) {
                Subscription subscription = new Subscription();
                subscription.setUser(userOptional.get());
                subscription.setTeam(teamOptional.get());

                return subscriptionRepository.save(subscription);
            }
        }
        return null;
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
