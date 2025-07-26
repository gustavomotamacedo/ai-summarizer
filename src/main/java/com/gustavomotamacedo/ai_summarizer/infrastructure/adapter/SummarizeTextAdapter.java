package com.gustavomotamacedo.ai_summarizer.infrastructure.adapter;

import org.springframework.stereotype.Service;

@Service
public class SummarizeTextAdapter {
    private String userRequest;
    private String userResponse;

    public SummarizeTextAdapter() {
    }

    public SummarizeTextAdapter(String userRequest) {
        this.userRequest = userRequest;
    }



    public String getUserRequest() {
        return userRequest;
    }

    public void setUserRequest(String userRequest) {
        this.userRequest = userRequest;
    }

    public String getUserResponse() {
        
        return "";
    }
}
