package com.gustavomotamacedo.ai_summarizer.domain.model;

public class UserInput {
    private String text;
    private SummaryTypes summaryType;

    public UserInput() {
    }

    public UserInput(String text, SummaryTypes summaryType) {
        this.text = text;
        this.summaryType = summaryType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public SummaryTypes getSummaryType() {
        return summaryType;
    }

    public void setSummaryType(SummaryTypes summaryType) {
        this.summaryType = summaryType;
    }
}
