package com.gustavomotamacedo.ai_summarizer.application.port;

import com.gustavomotamacedo.ai_summarizer.domain.model.AIRequest;
import com.gustavomotamacedo.ai_summarizer.domain.model.AIResponse;

public interface AIService {
    AIResponse chat(AIRequest request);
}
