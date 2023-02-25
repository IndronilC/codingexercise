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
public class Users {
    @JsonProperty("userId")
    private int userId;
    @JsonProperty("id_str")
    private String idStr;
    @JsonProperty("name")
    private String userName;
    @JsonProperty("screen_name")
    private String screenName;
    @JsonProperty("location")
    private String location;
    @JsonProperty("description")
    private String description;
    private String url;
}
