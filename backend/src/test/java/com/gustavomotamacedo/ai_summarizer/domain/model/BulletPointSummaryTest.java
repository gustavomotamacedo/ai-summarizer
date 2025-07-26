package com.gustavomotamacedo.ai_summarizer.domain.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BulletPointSummaryTest {

    private final BulletPointSummary bulletPointSummary;

    public BulletPointSummaryTest() {
        this.bulletPointSummary = new BulletPointSummary();
    }

    @Test
    public void applyPromptTest() {
        assertNotEquals("Lorem ipsum dolor et...", bulletPointSummary.applyPrompt("Lorem ipsum dolor et..."));
    }
}