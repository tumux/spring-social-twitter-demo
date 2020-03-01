package com.tumux.twitter.service;

import static lombok.AccessLevel.PRIVATE;

import com.tumux.twitter.configuration.SocialConfig;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = PRIVATE)
public class TweetService {

    final SocialConfig config;

    @Autowired
    public TweetService(SocialConfig config) {
        this.config = config;
    }

    public SearchResults searchTwitter(String query) {
        TwitterTemplate template = new TwitterTemplate(
            config.getConsumerKey(),
            config.getConsumerSecret(),
            config.getAccessToken(),
            config.getAccessTokenSecret());

        return template.searchOperations().search(query, 100);
    }
}
