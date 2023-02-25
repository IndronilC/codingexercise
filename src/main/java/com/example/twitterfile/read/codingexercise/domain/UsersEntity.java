package com.example.twitterfile.read.codingexercise.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long Id;
   @Column(name = "user_data_Id")
    private int userDataId;
   @Column(name = "id_str")
    private String idStr;
   @Column(name = "user_name")
    private String userName;
   @Column(name = "screen_name")
    private String screenName;
    @Column(name = "location")
    private String location;
    @Column(name = "description")
    private String description;
    @Column(name = "url")
    private String url;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "tweets_id")
    private TweetsEntity tweetsEntity;


}
