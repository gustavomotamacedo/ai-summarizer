package com.gustavomotamacedo.ai_summarizer.domain.model;

import java.util.List;

public class AIResponse {
    private String id;
    private String object;
    private Long created;
    private List<Choice> choices;
    private Usage usage;

    // Getters e setters

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getObject() { return object; }
    public void setObject(String object) { this.object = object; }

    public Long getCreated() { return created; }
    public void setCreated(Long created) { this.created = created; }

    public List<Choice> getChoices() { return choices; }
    public void setChoices(List<Choice> choices) { this.choices = choices; }

    public Usage getUsage() { return usage; }
    public void setUsage(Usage usage) { this.usage = usage; }

    // Classe interna Choice
    public static class Choice {
        private Integer index;
        private Message message;
        private String finishReason;

        public Integer getIndex() { return index; }
        public void setIndex(Integer index) { this.index = index; }

        public Message getMessage() { return message; }
        public void setMessage(Message message) { this.message = message; }

        public String getFinishReason() { return finishReason; }
        public void setFinishReason(String finishReason) { this.finishReason = finishReason; }
    }

    // Classe interna Message
    public static class Message {
        private String role;
        private String content;

        public String getRole() { return role; }
        public void setRole(String role) { this.role = role; }

        public String getContent() { return content; }
        public void setContent(String content) { this.content = content; }
    }

    // Classe interna Usage
    public static class Usage {
        private Integer promptTokens;
        private Integer completionTokens;
        private Integer totalTokens;

        public Integer getPromptTokens() { return promptTokens; }
        public void setPromptTokens(Integer promptTokens) { this.promptTokens = promptTokens; }

        public Integer getCompletionTokens() { return completionTokens; }
        public void setCompletionTokens(Integer completionTokens) { this.completionTokens = completionTokens; }

        public Integer getTotalTokens() { return totalTokens; }
        public void setTotalTokens(Integer totalTokens) { this.totalTokens = totalTokens; }
    }
}
