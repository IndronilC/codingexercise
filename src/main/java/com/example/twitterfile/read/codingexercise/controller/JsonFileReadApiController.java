package com.example.twitterfile.read.codingexercise.controller;

import com.example.twitterfile.read.codingexercise.dto.TweetRequest;
import com.example.twitterfile.read.codingexercise.dto.TweetResponse;
import com.example.twitterfile.read.codingexercise.service.JsonFileReadService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/file/v1")
@RequiredArgsConstructor
@Slf4j
public class JsonFileReadApiController {
    @Autowired
    JsonFileReadService jsonFileReadService;
    @Value("classpath:json/tweets.json")
    Resource resourceFile;

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping("/tweets")
    @ResponseStatus(HttpStatus.OK)
    public String getAllTweets(@RequestBody TweetRequest tweetRequest) throws IOException {
        log.info("Entered the getAllTweets method");
       JsonNode root = objectMapper.readTree(resourceFile.getFile());
       String json = objectMapper.writeValueAsString(root);
        return json;
    }


}
