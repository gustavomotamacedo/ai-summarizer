package com.gustavomotamacedo.ai_summarizer.domain.model;

import org.springframework.stereotype.Component;

@Component
public class TweetSummary implements ISummary{
    private String prompt;

    public TweetSummary() {
        this.prompt = "[SYSTEM]\n" +
                "Você é um assistente de criação de conteúdo para redes sociais. Seu objetivo é ler o texto fornecido pelo usuário e transformá‑lo em um tweet engajador.\n" +
                "\n" +
                "[USER]\n" +
                "Resuma o seguinte texto em um tweet de no máximo 280 caracteres:\n" +
                "\n" +
                "“<replace>”\n" +
                "\n" +
                "REQUISITOS:\n" +
                "1. Preserve a ideia central e os pontos-chave.  \n" +
                "2. Adote um tom informal e direto, que chame a atenção logo no início.  \n" +
                "3. Use até 2 hashtags relevantes.  \n" +
                "4. Inclua um call to action curto (por exemplo: “Curta e retweet!”).  \n" +
                "5. Mantenha o limite de 280 caracteres, contando espaços e hashtags.\n";
    }

    @Override
    public String applyPrompt(String userText) {
        return prompt.replace("<replace>", userText);
    }
}
