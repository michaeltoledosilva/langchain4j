🤖 ERP AI Assistant — LangChain4j + Spring Boot

Assistente inteligente integrado a um cenário corporativo de ERP, desenvolvido com Java + Spring Boot + LangChain4j, focado em:

IA Generativa aplicada ao negócio

Arquitetura de Agente (não é só “chat com LLM”)

RAG (Retrieval Augmented Generation)

Streaming de respostas em tempo real

Cache de respostas para performance

🎯 Objetivo do Projeto

Criar um Agente de IA corporativo capaz de responder perguntas sobre regras de negócio de um ERP, utilizando:

Base de conhecimento

Contexto semântico (embeddings)

Orquestração de ferramentas

Respostas rápidas e naturais

A proposta é sair do modelo:

“Pergunte qualquer coisa para o GPT”

E entrar no modelo:

IA que entende o domínio do sistema e age como parte da arquitetura

🧠 Arquitetura do Agente

Cliente (Postman / Front-end)
↓
AssistantController (REST API)
↓
AssistantOrchestrator (Cérebro do agente)
↓
ErpAssistantAgent (Interface da IA)
↓
Ferramentas de negócio (Tools)
↓
RAG (Contexto + Embeddings)
↓
Cache de respostas
↓
Streaming de tokens em tempo real

🚀 Tecnologias Utilizadas
Tecnologia	Função
Java 17+	Linguagem principal
Spring Boot	Backend e API REST
LangChain4j	Framework de agentes de IA
OpenAI API	Modelos de linguagem e embeddings
RAG	Contexto baseado em conhecimento
SSE (Server-Sent Events)	Streaming de resposta
Cache Service	Otimização de performance
🔥 Funcionalidades Implementadas

Agente de IA com arquitetura real

RAG com base de conhecimento

Orquestração de ferramentas de negócio

Streaming de resposta em tempo real

Cache de respostas

🌍 Interface do Agente
Pergunta normal

POST /api/assistant

{
  "systemCode": "FIN",
  "functionalityCode": "AP",
  "question": "Se um título vencer hoje, quando começam os juros?"
}

Pergunta com Streaming

POST /api/assistant/stream

Retorno é enviado token por token em tempo real via SSE.

⚙️ Configuração

No application.properties:

openai.api.key=SUA_CHAVE_AQUI
openai.model=gpt-4o-mini
openai.embedding.model=text-embedding-3-small

📂 Estrutura do Projeto
application
 AssistantOrchestrator.java   → Cérebro do agente
 ErpAssistantAgent.java       → Interface da IA
 ErpBusinessTools.java        → Ferramentas de negócio

config
 AssistantConfig.java
 ChatModelConfig.java
 EmbeddingConfig.java
 CacheConfig.java

web
 AssistantController.java     → Endpoints REST

🧩 Conceitos de IA Aplicados

Agent Orchestration

RAG (Retrieval Augmented Generation)

Tool Calling

Embeddings

Streaming de LLM

Cache para redução de custo e latência

📈 Resultado

Respostas alinhadas às regras do ERP, com:

Menor latência

Melhor experiência do usuário

Redução de chamadas repetidas ao modelo

Se quiser, no próximo passo eu deixo isso ainda mais forte pra recrutador (com seção "Diferenciais Técnicos" e "O que esse projeto demonstra sobre mim como desenvolvedor").
