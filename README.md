🤖 ERP AI Assistant — LangChain4j + Spring Boot

Assistente inteligente integrado a um cenário corporativo de ERP, desenvolvido com Java + Spring Boot + LangChain4j, focado em:

✅ IA Generativa aplicada a negócio

✅ Arquitetura de Agente de IA (não é só “chat com LLM”)

✅ RAG (Retrieval Augmented Generation)

✅ Streaming de respostas (tempo real)

✅ Cache de respostas (performance)

🎯 Objetivo do Projeto

Criar um Agente de IA corporativo capaz de responder perguntas sobre regras de negócio de um ERP, utilizando:

📚 Base de conhecimento

🧠 Contexto semântico (embeddings)

🧩 Orquestração de ferramentas (tools)

⚡ Respostas rápidas e naturais

A proposta é sair do modelo de:

“Pergunte qualquer coisa para o GPT”

E entrar no modelo de:

IA que entende o domínio do sistema e age como parte da arquitetura

🧠 Arquitetura do Agente
Cliente (Postman / Front)
        ↓
AssistantController (REST API)
        ↓
AssistantOrchestrator  ← Cérebro do Agente
        ↓
RAG Context (Embeddings + Knowledge Base)
        ↓
Ferramentas de Negócio (Tools)
        ↓
Cache de Respostas
        ↓
Streaming de Tokens (tempo real)

🚀 Tecnologias Utilizadas
Tecnologia	Função
Java 17+	Linguagem principal
Spring Boot	Backend e API REST
LangChain4j	Framework para agentes de IA
OpenAI API	Modelos de linguagem e embeddings
RAG	Respostas baseadas em conhecimento
SSE (Server-Sent Events)	Streaming de resposta
Cache Service	Otimização de performance
🧩 Funcionalidades Implementadas

🤖 Agente de IA com contexto de ERP

📚 RAG com base de conhecimento

⚡ Streaming de respostas em tempo real

🚀 Cache de respostas para ganho de performance

🧠 Embeddings para busca semântica

🔧 Arquitetura preparada para Tools de negócio

🌐 Interface do Agente

Resultado: respostas alinhadas às regras do ERP.

🔌 Endpoints da API
📌 Pergunta Normal

POST /api/assistant

Body

{
  "systemCode": "FIN",
  "functionalityCode": "AP",
  "question": "Se um título vencer hoje, quando começam os juros?"
}

⚡ Pergunta com Streaming

POST /api/assistant/stream

Retorno palavra por palavra via Server-Sent Events.

⚙️ Configuração

No application.properties:

openai.api.key=SUA_CHAVE_AQUI
openai.model=gpt-4o-mini
openai.embedding.model=text-embedding-3-small

🏗 Estrutura do Projeto
application
 ├── AssistantOrchestrator.java   → Cérebro do agente
 ├── ErpAssistantAgent.java       → Interface da IA
 ├── ErpBusinessTools.java        → Tools de negócio

config
 ├── AssistantConfig.java
 ├── ChatModelConfig.java
 ├── EmbeddingConfig.java
 ├── CacheConfig.java

web
 └── AssistantController.java

💡 Conceitos de IA Aplicados

Agent Orchestration

RAG (Retrieval Augmented Generation)

Embeddings semânticos

Tool Calling

Streaming de tokens

Cache de respostas

🏁 Resultado

Um Agente de IA corporativo, integrado à arquitetura, capaz de:

✔ Entender o domínio do ERP
✔ Usar base de conhecimento
✔ Responder em tempo real
✔ Escalar com performance

📎 Sobre o Projeto

Este projeto foi desenvolvido como estudo prático de IA aplicada a sistemas corporativos, focando em arquitetura de agentes reais.
