package com.ortega.scoreappspringboot.controller;

import com.ortega.scoreappspringboot.model.Match;
import com.ortega.scoreappspringboot.request.CreateMatchRequest;
import com.ortega.scoreappspringboot.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/matches")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @GetMapping
    public List<Match> getMatches(){
        return matchService.findAll();
    }

    @PostMapping
    public Match createMatch(@RequestBody CreateMatchRequest request){
        return matchService.save(request);
    }

    @GetMapping("/{userId}")
    public List<Match> getMatch(@PathVariable String userId){
        return matchService.findAllMatchesByUserSubscribed(userId);
    }

    @GetMapping("/current/{matchId}")
    public Match getMatchCurrent(@PathVariable String matchId) {
        return matchService.findById(matchId);
    }

}
