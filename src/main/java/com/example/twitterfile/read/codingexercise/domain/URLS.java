package com.example.twitterfile.read.codingexercise.domain;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class URLS {
    @JsonProperty("twitterUrl")
    private String twitterUrl;
    @JsonProperty("expanded_url")
    private String expandedUrl;
    @JsonProperty("indices")
    private List<Integer> indices;
}
