package com.example.twitterfile.read.codingexercise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class TweetsDTO {

    private String createdAt;
    private String idStr;
    private String text;
    private String source;
    private boolean isTruncated;
}
