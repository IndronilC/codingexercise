package com.example.twitterfile.read.codingexercise.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class TweetsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long Id;
    @Column(name = "created_at")
    private String createdAt;
    @Column(name = "id_str")
    private String idStr;
    @Column(name = "text")
    private String text;
    @Column(name = "source")
    private String source;
    @Column(name = "truncated")
    private boolean isTruncated;

    @Column(name = "in_reply_to_status_id", nullable = true)
    private String in_reply_to_status_id;

    @Column(name = "in_reply_to_status_id_str", nullable = true)
    private String in_reply_to_status_id_str;

    @Column(name = "in_reply_to_user_id", nullable = true)
    private String in_reply_to_user_id;

    @Column(name = "in_reply_to_user_id_str", nullable = true)
    private String in_reply_to_user_id_str;

    @Column(name = "in_reply_to_screen_name", nullable = true)
    private String in_reply_to_screen_name;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "tweetsEntity")
    private UsersEntity usersEntity;

    TweetsEntity(){}

}
