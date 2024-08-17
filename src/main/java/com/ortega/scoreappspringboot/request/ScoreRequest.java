package com.ortega.scoreappspringboot.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScoreRequest {

    private String match;
    private String scoreA;
    private String scoreB;

}
