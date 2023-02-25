package com.example.twitterfile.read.codingexercise.domain;

import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TwitterURL {
    @Embedded
    private URLS urls;
}
