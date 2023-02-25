package com.example.twitterfile.read.codingexercise.controller;

import com.example.twitterfile.read.codingexercise.dto.TweetResponse;
import com.example.twitterfile.read.codingexercise.dto.TweetsDTO;
import com.example.twitterfile.read.codingexercise.service.JsonFileReadService;
import com.example.twitterfile.read.codingexercise.service.TweetsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/file/v1")
@RequiredArgsConstructor
@Slf4j
public class TweetsAPIController {
    @Autowired
    TweetsService tweetsService;
    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/tweets")
    public ResponseEntity<List<TweetResponse>> getAllTweets()  {
        List<TweetsDTO> tweetsDTOList = tweetsService.getAllTweets();
        List<TweetResponse> tweetResponseList = tweetsDTOList.stream()
                .map(tweetsDTO -> modelMapper.map(tweetsDTO, TweetResponse.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(tweetResponseList, HttpStatus.OK);
    }


}
