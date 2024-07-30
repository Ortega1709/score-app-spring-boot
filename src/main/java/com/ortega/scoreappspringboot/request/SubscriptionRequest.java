package com.ortega.scoreappspringboot.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class SubscriptionRequest {

    private String user;
    private String team;

}
