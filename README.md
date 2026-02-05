🤖 ERP AI Assistant — LangChain4j + Spring Boot

Assistente inteligente integrado a um cenário corporativo de ERP, desenvolvido com Java + Spring Boot + LangChain4j, focado em:

✅ IA Generativa aplicada a negócio
✅ Arquitetura de Agente (não é só “chat com LLM”)
✅ RAG (Retrieval Augmented Generation)
✅ Streaming de respostas (tempo real)
✅ Cache de respostas (performance)

🎯 Objetivo do Projeto

Criar um Agente de IA corporativo capaz de responder perguntas sobre regras de negócio de um ERP, utilizando:

Base de conhecimento

Contexto semântico (embeddings)

Orquestração de ferramentas

Respostas rápidas e naturais

A proposta é sair do modelo de “pergunte qualquer coisa para o GPT” e entrar no modelo de:

🧠 IA que entende o domínio do sistema e age como parte da arquitetura

🧠 Arquitetura
Cliente (Postman / Front)
        │
        ▼
AssistantController (REST)
        │
        ▼
AssistantOrchestrator  ← 🧠 Cérebro da IA
        │
        ├── 🔎 RAG (Embeddings + Contexto)
        ├── 🗂️ KnowledgeBase (Regras do ERP)
        ├── 🧮 Ferramentas de negócio (Tools)
        ├── ⚡ Cache de respostas
        └── 🌊 Streaming de tokens (tempo real)

🚀 Tecnologias Utilizadas
Tecnologia	Função
Java 17+	Linguagem principal
Spring Boot	Backend e API REST
LangChain4j	Framework para agentes de IA
OpenAI API	Modelos de linguagem e embeddings
RAG	Contexto baseado em conhecimento
SSE (Server-Sent Events)	Streaming de resposta
Cache Service	Otimização de performance
🔥 Funcionalidades Implementadas
🧠 1. Agente de IA

Interface do agente:

public interface ErpAssistantAgent {

    @SystemMessage("""
        Você é um assistente de ERP corporativo.
        Use o contexto fornecido e utilize ferramentas quando necessário.
        Nunca invente regras.
    """)
    String chat(@UserMessage String message);
}

🌊 2. Streaming de Respostas (Tempo Real)

O usuário não espera a resposta completa — ele recebe conforme a IA gera.

Endpoint:

POST /api/assistant/stream


Benefícios:

Sensação de resposta instantânea

Melhor experiência do usuário

Ideal para chat corporativo

⚡ 3. Cache de Respostas

Perguntas repetidas são respondidas diretamente do cache.

Resultado:

Respostas quase instantâneas

Redução de chamadas ao modelo

Economia de custo

🔎 4. RAG (Contexto Inteligente)

Antes da IA responder:

A pergunta vira um embedding

Buscamos regras similares na base

O contexto é injetado no prompt

Resultado: respostas alinhadas às regras do ERP.

📡 Endpoints da API
📘 Pergunta Normal
POST /api/assistant


Body:

{
  "systemCode": "FIN",
  "functionalityCode": "AP",
  "question": "Se um título vencer hoje, quando começam os juros?"
}

🌊 Pergunta com Streaming
POST /api/assistant/stream

⚙️ Configuração
application.properties
openai.api.key= SUA_CHAVE_AQUI
openai.model=gpt-4o-mini
openai.embedding.model=text-embedding-3-small

🏗️ Estrutura do Projeto
application
 ├── AssistantOrchestrator.java  ← Cérebro do agente
 ├── ErpAssistantAgent.java      ← Interface da IA
 └── ErpBusinessTools.java       ← Ferramentas

config
 ├── AssistantConfig.java
 ├── ChatModelConfig.java
 ├── EmbeddingConfig.java
 └── CacheConfig.java

web
 └── AssistantController.java

💡 Conceitos de IA Aplicados

Agent Orchestration

RAG (Retrieval Augmented Generation)

Tool Calling

Prompt Engineering

Token Streaming

Caching Strategy

IA aplicada a domínio corporativo

🧩 Próximos Passos

 Histórico de conversa (Memory)

 Vetor DB real (PGVector / Pinecone)

 Ferramentas reais de ERP

 Autenticação

 Frontend Chat

👨‍💻 Autor

Projeto desenvolvido como estudo avançado de IA aplicada a sistemas corporativos, focado em:

Arquitetura • Performance • Experiência do Usuário • Engenharia de IA

⭐ Conclusão

Este projeto demonstra como integrar IA Generativa a sistemas reais, indo além de um simples chatbot, e transformando a IA em um componente arquitetural do sistema.
