package com.example.twitterfile.read.codingexercise.repository;

import com.example.twitterfile.read.codingexercise.domain.TweetsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetsRepository extends CrudRepository<TweetsEntity, Long> {
}
