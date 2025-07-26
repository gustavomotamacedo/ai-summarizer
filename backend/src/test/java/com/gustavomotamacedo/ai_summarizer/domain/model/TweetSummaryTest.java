package com.gustavomotamacedo.ai_summarizer.domain.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TweetSummaryTest {

    private TweetSummary tweetSummary;

    public TweetSummaryTest() {
        tweetSummary = new TweetSummary();
    }

    @Test
    public void applyPromptTest() {
        assertNotEquals("Lorem ipsum dolor...", tweetSummary.applyPrompt("Lorem ipsum dolor..."));
    }
}