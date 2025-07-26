package com.gustavomotamacedo.ai_summarizer.domain.model;

import org.springframework.stereotype.Component;

@Component
public class BulletPointSummary implements ISummary {
    private String prompt;

    public BulletPointSummary() {
        this.prompt = "[SYSTEM]\n" +
                "Você é um assistente de resumos. Seu objetivo é ler o texto fornecido pelo usuário, identificar as ideias principais e devolvê-las como uma lista de bullet points concisos, claros e sem repetições.\n" +
                "\n" +
                "[USER]\n" +
                "Por favor, resuma o seguinte texto em bullet points:\n" +
                "\n" +
                "“<replace>”\n" +
                "\n" +
                "REQUISITOS:\n" +
                "1. Cada bullet point deve conter **apenas uma ideia** central.\n" +
                "2. Use no máximo 8–10 bullets (ou personalize o número conforme sua necessidade).\n" +
                "3. Seja sucinto: cada ponto não deve ultrapassar 20 palavras.\n" +
                "4. Mantenha termos-chave e conceitos importantes.\n" +
                "5. Não adicione informação nova ou opinião — apenas reformule o que já está no texto.\n" +
                "6. Responda sempre em português brasileiro.\n" +
                "\n" +
                "FORMATO DE SAÍDA (HTML):\n" +
                "- Retorne **somente** um fragmento HTML, sem `<html>`, `<head>` ou `<body>` completos.\n" +
                "- Envolva toda a lista em `<ul>` e cada bullet point em `<li>`.\n" +
                "- Envolva termos-chave e conceitos importantes em `<strong>`.\n" +
                "- Não inclua a tag `<div>`, pois a resposta será inserida dentro de uma `<div>` existente na página.\n";

    }

    @Override
    public String applyPrompt(String userText) {
        return prompt.replace("<replace>", userText);
    }
}
