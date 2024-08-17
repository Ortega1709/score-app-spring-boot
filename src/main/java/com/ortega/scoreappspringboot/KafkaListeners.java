package com.ortega.scoreappspringboot;

import com.ortega.scoreappspringboot.model.Score;
import com.ortega.scoreappspringboot.service.JsonService;
import com.ortega.scoreappspringboot.service.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaListeners {

    @Autowired
    private JsonService jsonService;
    @Autowired
    private WebSocketService webSocketService;

    @KafkaListener(
            topics = "score",
            groupId = "group_id"
    )
    public void listen(String message) {
        Score score = jsonService.fromJson(message, Score.class);
        webSocketService.sendScore(score);
    }

}
