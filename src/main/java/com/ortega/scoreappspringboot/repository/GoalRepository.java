package com.ortega.scoreappspringboot.repository;

import com.ortega.scoreappspringboot.model.Goal;
import com.ortega.scoreappspringboot.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GoalRepository extends JpaRepository<Goal, String> {
    Optional<List<Goal>> findGoalsByMatch(Match match);
}
