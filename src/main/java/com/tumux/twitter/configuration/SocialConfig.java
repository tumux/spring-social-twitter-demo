package com.tumux.twitter.configuration;

import static lombok.AccessLevel.PRIVATE;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Service
@Getter
@ToString
@Validated
@FieldDefaults(level = PRIVATE)
public class SocialConfig {

    @Value("${twitter.consumerKey}")
    @NotBlank String consumerKey;

    @Value("${twitter.consumerSecret}")
    @NotBlank String consumerSecret;

    @Value("${twitter.accessToken}")
    @NotBlank String accessToken;

    @Value("${twitter.accessTokenSecret}")
    @NotBlank String accessTokenSecret;
}