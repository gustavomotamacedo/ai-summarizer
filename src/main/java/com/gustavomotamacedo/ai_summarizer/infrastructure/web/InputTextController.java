package com.gustavomotamacedo.ai_summarizer.infrastructure.web;

import com.gustavomotamacedo.ai_summarizer.domain.model.BulletPointSummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.Locale;

@RestController
@RequestMapping("api/v1")
public class InputTextController {

    private final ChatModel chatModel;
    private final BulletPointSummary bulletPointSummary;
    private static final Logger log = LoggerFactory.getLogger(InputTextController.class);

    public InputTextController(ChatModel chatModel) {
        this.chatModel = chatModel;
        this.bulletPointSummary = new BulletPointSummary();
    }

    @PostMapping("/input")
    public ResponseEntity<String> inputText(@RequestBody String text) {
        try {
            if ()
            String response = this.chatModel.call(bulletPointSummary.applyPrompt(text.toLowerCase()));
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Error processing chat data: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Sorry, an error has occurred with api service.");
        }
    }

}
