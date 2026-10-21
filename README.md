# Lab API Fala Orçamento - Spring AI

API Inteligente com Reconhecimento de Fala para controle de orçamentos usando Spring AI.

## Tecnologias
- Java 17
- Spring Boot 3
- Spring AI (OpenAI Whisper + ChatGPT)
- TranscriptionModel

## Endpoints
- POST /api/audio/transcribe - Transcreve áudio em texto
- POST /api/budget/voice - Cria orçamento por voz

## Como funciona
1. Recebe arquivo de áudio
2. Transcreve com Whisper (Spring AI)
3. Processa com IA para extrair valor e descrição
