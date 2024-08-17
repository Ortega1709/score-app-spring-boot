package com.ortega.scoreappspringboot.controller;

import com.ortega.scoreappspringboot.model.Score;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class ScoreController {

    @MessageMapping("/score.update/{id}")
    @SendTo("/topic/score/{id}")
    public void updateScore(Score score) {
        log.info("score update {}", score.toString());
    }

}
