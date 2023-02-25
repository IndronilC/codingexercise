package com.example.twitterfile.read.codingexercise.service;

import com.example.twitterfile.read.codingexercise.domain.TweetsEntity;
import com.example.twitterfile.read.codingexercise.dto.TweetsDTO;
import com.example.twitterfile.read.codingexercise.repository.TweetsRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TweetsService {

    @Autowired
    private final TweetsRepository tweetsRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<TweetsDTO> getAllTweets(){
        ArrayList<TweetsDTO> tweetsDTOArrayList = new ArrayList<TweetsDTO>();
        tweetsRepository.findAll().stream().forEach(tweets -> saveTweetsDataToDTO(tweets, tweetsDTOArrayList));
        return tweetsDTOArrayList;
    }

    private void saveTweetsDataToDTO(TweetsEntity tweets, ArrayList<TweetsDTO> tweetsDTO) {
        TweetsDTO tweetsDTO1 = modelMapper.map(tweets, TweetsDTO.class);
        tweetsDTO.add(tweetsDTO1);
    }
}
