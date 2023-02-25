package com.example.twitterfile.read.codingexercise.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class TweetRequest {
    private String createdAt;
    private String id;
    private String text;
}