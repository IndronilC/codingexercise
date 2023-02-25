package com.example.twitterfile.read.codingexercise.repository;

import com.example.twitterfile.read.codingexercise.domain.TweetsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetsRepository extends JpaRepository<TweetsEntity, Long> {
}
