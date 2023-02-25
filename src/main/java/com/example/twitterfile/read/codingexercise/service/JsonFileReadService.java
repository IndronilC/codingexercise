package com.example.twitterfile.read.codingexercise.service;

import com.example.twitterfile.read.codingexercise.domain.TweetsEntity;
import com.example.twitterfile.read.codingexercise.repository.TweetsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JsonFileReadService {

    private final TweetsRepository tweetsRepository;

    public void save(List<TweetsEntity> tweets){
        tweetsRepository.saveAll(tweets);

    }

    public void save(TweetsEntity tweets){
        tweetsRepository.save(tweets);
    }


}
