package com.example.twitterfile.read.codingexercise;

import com.example.twitterfile.read.codingexercise.domain.TweetsEntity;
import com.example.twitterfile.read.codingexercise.domain.UsersEntity;
import com.example.twitterfile.read.codingexercise.dto.Tweets;
import com.example.twitterfile.read.codingexercise.service.JsonFileReadService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.modelmapper.ModelMapper;


import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@SpringBootApplication
@Slf4j
public class CodingexerciseApplication {
	@Value("classpath:json/tweets.json")
	Resource resourceFile;

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(CodingexerciseApplication.class, args);
	}
	@Bean
	CommandLineRunner runner(JsonFileReadService jsonFileReadService){
		return args -> {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			TypeReference<List<Tweets>> typeReference = new TypeReference<List<Tweets>>() {
			};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/tweets.json");
			try{
				List<Tweets> tweets = objectMapper.readValue(inputStream,typeReference);
				logTweets(tweets);
				writeToDatabase(tweets, jsonFileReadService);
			}catch (IOException exception){
				log.error(" the exception is {} ", exception.getMessage());
			}

		};

	}

	public void logTweets(List<Tweets> tweets){
		tweets.stream().map(tweets1 -> tweets1.getUser()).forEach(users -> log.info(" users : {}", users));

	}

	public void writeToDatabase(List<Tweets> tweets, JsonFileReadService jsonFileReadService){
		tweets.stream().forEach(tweets1 -> saveTweets(tweets1, jsonFileReadService));
	}

	public void saveTweets(Tweets tweets, JsonFileReadService jsonFileReadService ){
     TweetsEntity tweetsEntity = modelMapper().map(tweets, TweetsEntity.class);
	 UsersEntity userEntity = modelMapper().map(tweets.getUser(), UsersEntity.class);
	 tweetsEntity.setUsersEntity(userEntity);
	 jsonFileReadService.save(tweetsEntity);
	}

}
