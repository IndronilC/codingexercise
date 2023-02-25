package com.example.twitterfile.read.codingexercise.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TweetResponse {
    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("id_str")
    private String idStr;
    private String text;
    private String source;
}
