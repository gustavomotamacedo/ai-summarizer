package com.gustavomotamacedo.ai_summarizer.domain.model;

public class BulletPointSummary implements ISummary {
    private String prompt;

    public BulletPointSummary() {
        this.prompt = "testing ";
    }

    @Override
    public String applyPrompt(String userText) {
        return prompt.concat(userText);
    }
}
