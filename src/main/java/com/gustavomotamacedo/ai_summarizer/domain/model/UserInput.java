package com.gustavomotamacedo.ai_summarizer.domain.model;

public class UserInput {
    private String text;
    private String summaryType;

    public UserInput() {
    }

    public UserInput(String text, String summaryType) {
        this.text = text;
        this.summaryType = summaryType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSummaryType() {
        return summaryType;
    }

    public void setSummaryType(String summaryType) {
        this.summaryType = summaryType;
    }
}
