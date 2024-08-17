package com.ortega.scoreappspringboot.controller;

import com.ortega.scoreappspringboot.request.ScoreRequest;
import com.ortega.scoreappspringboot.service.JsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/publish")
public class PublishController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private JsonService jsonService;

    @PostMapping("/score")
    public void publishScore(@RequestBody ScoreRequest scoreRequest) {
        kafkaTemplate.send("score", jsonService.toJson(scoreRequest));
    }

}
