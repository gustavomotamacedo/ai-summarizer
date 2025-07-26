package com.gustavomotamacedo.ai_summarizer.infrastructure.web;

import com.gustavomotamacedo.ai_summarizer.domain.model.BulletPointSummary;
import com.gustavomotamacedo.ai_summarizer.domain.model.TweetSummary;
import com.gustavomotamacedo.ai_summarizer.domain.model.UserInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "http://localhost:5173")
public class InputTextController {

    private final ChatModel chatModel;
    private final BulletPointSummary bulletPointSummary;
    private final TweetSummary tweetSummary;
    private static final Logger log = LoggerFactory.getLogger(InputTextController.class);

    public InputTextController(ChatModel chatModel) {
        this.chatModel = chatModel;
        this.bulletPointSummary = new BulletPointSummary();
        this.tweetSummary = new TweetSummary();
    }

    @PostMapping("/input")
    public ResponseEntity<String> inputText(@RequestBody UserInput userInput) {
        try {
            String response = "";
            if (userInput.getSummaryType().equals("TWEET")){
                response = this.chatModel.call(tweetSummary.applyPrompt(userInput.getText().toLowerCase()));
            } else if (userInput.getSummaryType().equals("BULLET_POINTS")) {
                response = this.chatModel.call(bulletPointSummary.applyPrompt(userInput.getText().toLowerCase()));
            } else {
                throw new Exception("Invalid Summary Type!");
            }
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Error processing chat data: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Sorry, an error has occurred with api service.");
        }
    }

}
