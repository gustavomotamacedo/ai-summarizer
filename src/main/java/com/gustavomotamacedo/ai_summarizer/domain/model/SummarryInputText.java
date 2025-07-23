package com.gustavomotamacedo.ai_summarizer.domain.model;

public class SummarryInputText {
    private String text;

    public SummarryInputText() {
    }

    public SummarryInputText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
