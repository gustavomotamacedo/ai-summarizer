package com.gustavomotamacedo.ai_summarizer.infrastructure.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.Locale;

@RestController
@RequestMapping("api/v1")
public class InputTextController {

    @PostMapping("/input")
    public ResponseEntity<String> inputText(@RequestBody String text) {
        return ResponseEntity.ok(text.toLowerCase(Locale.ROOT));
    }

}
