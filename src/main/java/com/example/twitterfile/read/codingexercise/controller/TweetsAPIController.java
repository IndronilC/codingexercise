package com.example.twitterfile.read.codingexercise.controller;

import com.example.twitterfile.read.codingexercise.dto.TweetResponse;
import com.example.twitterfile.read.codingexercise.service.JsonFileReadService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/file/v1")
@RequiredArgsConstructor
@Slf4j
public class TweetsAPIController {
    @Autowired
    JsonFileReadService jsonFileReadService;
    @Value("classpath:json/tweets.json")
    Resource resourceFile;

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping("/tweets")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<TweetResponse> getAllTweets()  {
       return null;
    }


}
