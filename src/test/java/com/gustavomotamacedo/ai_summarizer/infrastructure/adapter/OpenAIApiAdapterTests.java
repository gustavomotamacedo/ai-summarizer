package com.gustavomotamacedo.ai_summarizer.infrastructure.adapter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OpenAIApiAdapterTests {
    // Testes unitários para OpenAIApiAdapter

    // Teste para verificar construtor da classe
    @Test
    public void testConstructor() {
        OpenAIApiAdapter adapter = new OpenAIApiAdapter();
        assertNotNull(adapter);
    }
}
