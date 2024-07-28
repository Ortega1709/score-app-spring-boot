package com.ortega.scoreappspringboot.controller;

import com.ortega.scoreappspringboot.model.Team;
import com.ortega.scoreappspringboot.service.TeamService;
import jakarta.persistence.PostLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping
    public List<Team> getAllTeams(){
        return teamService.getAllTeams();
    }

    @GetMapping("/{id}")
    public Team getTeamById(@PathVariable("id") String id){
        return teamService.getTeamById(id).orElse(null);
    }

    @PostMapping
    public List<Team> createTeam(@RequestBody List<Team> team){
        return teamService.saveTeams(team);
    }
}
