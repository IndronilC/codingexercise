package com.example.twitterfile.read.codingexercise.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(Include.NON_NULL)
public class Tweets {
    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("id_str")
    private String idStr;
    private String text;
    private String source;
    @JsonProperty("truncated")
    private boolean isTruncated;
    @JsonProperty("in_reply_to_status_id")
    private String in_reply_to_status_id;
    @JsonProperty("in_reply_to_status_id_str")
    private String in_reply_to_status_id_str;
    @JsonProperty("in_reply_to_user_id")
    private String in_reply_to_user_id;
    @JsonProperty("in_reply_to_user_id_str")
    private String in_reply_to_user_id_str;
    @JsonProperty("in_reply_to_screen_name")
    private String in_reply_to_screen_name;

    @Embedded
    private Users user;

}
