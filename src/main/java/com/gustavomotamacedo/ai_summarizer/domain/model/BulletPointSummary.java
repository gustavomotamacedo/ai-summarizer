package com.gustavomotamacedo.ai_summarizer.domain.model;

public class BulletPointSummary implements ISummary {
    private String prompt;

    public BulletPointSummary() {

    }

    @Override
    public String applyPrompt(String userText) {
        return prompt.concat(userText);
    }
}
