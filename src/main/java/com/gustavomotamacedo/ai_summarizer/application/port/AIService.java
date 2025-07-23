package com.gustavomotamacedo.ai_summarizer.application.port;

public interface AIService {
    AIResponse chat(AIRequest request);
}
