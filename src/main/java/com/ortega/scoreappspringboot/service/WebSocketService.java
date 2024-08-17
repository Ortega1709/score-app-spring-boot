package com.ortega.scoreappspringboot.service;

import com.ortega.scoreappspringboot.model.Match;
import com.ortega.scoreappspringboot.model.Score;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class WebSocketService {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    @Autowired
    private JsonService jsonService;
    @Autowired
    private MatchService matchService;

    public void sendScore(Score score) {
        String destination = "/topic/score/" + score.getMatch();
        log.info("Sending message to {}", destination);

        messagingTemplate.convertAndSend(destination, jsonService.toJson(score));
        matchService.addGoal(score);
    }
}
