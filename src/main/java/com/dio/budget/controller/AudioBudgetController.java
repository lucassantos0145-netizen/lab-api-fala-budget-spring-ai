package com.dio.budget.controller;

import org.springframework.ai.openai.OpenAiAudioTranscriptionModel;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AudioBudgetController {

    private final OpenAiAudioTranscriptionModel transcriptionModel;
    private final ChatModel chatModel;

    public AudioBudgetController(OpenAiAudioTranscriptionModel transcriptionModel, ChatModel chatModel) {
        this.transcriptionModel = transcriptionModel;
        this.chatModel = chatModel;
    }

    @PostMapping("/audio/transcribe")
    public Map<String, String> transcribe(@RequestParam("file") MultipartFile file) {
        String text = transcriptionModel.call(file.getResource()).getResult().getOutput();
        return Map.of("transcricao", text);
    }

    @PostMapping("/budget/voice")
    public Map<String, Object> voiceBudget(@RequestParam("file") MultipartFile file) {
        String transcricao = transcriptionModel.call(file.getResource()).getResult().getOutput();
        String prompt = "Extraia valor e descricao de: '" + transcricao + "'";
        String resposta = chatModel.call(prompt);
        return Map.of("audio", transcricao, "ia", resposta);
    }
}
