package com.ortega.scoreappspringboot.controller;

import com.ortega.scoreappspringboot.model.Subscription;
import com.ortega.scoreappspringboot.request.SubscriptionRequest;
import com.ortega.scoreappspringboot.service.SubscriptionService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @GetMapping("/subscriptions")
    public List<Subscription> getSubscriptions() {
        return subscriptionService.getAllSubscriptions();
    }

    @GetMapping("subscriptions/{id}")
    public Subscription getSubscription(@PathVariable String id) {
        return subscriptionService.getSubscriptionById(id);
    }

    @GetMapping("/{userId}/subscriptions")
    public List<Subscription> getSubscriptionsByUserId(@PathVariable String userId) {
        return subscriptionService.getSubscriptionsByUserId(userId);
    }

    @PostMapping("/subscriptions")
    public Subscription subscribe(@RequestBody SubscriptionRequest subscription) {
        return subscriptionService.subscribe(subscription.getUser(), subscription.getTeam());
    }

    @DeleteMapping("subscriptions/{id}")
    public void deleteSubscription(@PathVariable String id) {
        subscriptionService.deleteSubscription(id);
    }

}
