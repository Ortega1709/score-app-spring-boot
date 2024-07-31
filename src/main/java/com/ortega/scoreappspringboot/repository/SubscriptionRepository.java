package com.ortega.scoreappspringboot.repository;

import com.ortega.scoreappspringboot.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, String> {

    List<Subscription> findByUserId(String userId);
    List<Subscription> findByTeamId(String userId);
    boolean existsByUserIdAndTeamId(String userId, String teamId);

}
