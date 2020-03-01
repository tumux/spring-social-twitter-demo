package com.tumux.twitter.controller;

import static lombok.AccessLevel.PRIVATE;

import com.tumux.twitter.model.Query;
import com.tumux.twitter.service.TweetService;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@FieldDefaults(level = PRIVATE)
public class SearchController {

    final TweetService service;

    @Autowired
    public SearchController(TweetService service) {
        this.service = service;
    }

    @GetMapping("/search/{query}")
    @ResponseBody
    public SearchResults search(Query query) throws IOException {
        return service.searchTwitter(query.getQuery());
    }
}
