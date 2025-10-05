# Validador de HTML - Trabalho de Algoritmos e Estrutura de Dados

> **Autores:** Christian Alves dos Santos e Nicolle Formigari Poncio

## 📋 Descrição do Projeto

Este projeto implementa um **Validador de HTML** desenvolvido em Java com interface gráfica Swing. O aplicativo verifica a validade sintática de arquivos HTML, garantindo que todas as tags estejam adequadamente balanceadas e fechadas corretamente.

## 🎯 Objetivo Acadêmico

O projeto foi desenvolvido como trabalho prático da disciplina de **Algoritmos e Estrutura de Dados**, com foco na implementação e aplicação de:

- **Pilhas (Stack)** - Para controle de abertura e fechamento de tags HTML
- **Listas Encadeadas** - Implementação personalizada de estruturas de dados
- **Tratamento de Exceções** - Para casos de HTML malformado
- **Interface Gráfica** - Usando Java Swing

## ⚡ Funcionalidades

- ✅ **Validação sintática de HTML**: Verifica se todas as tags estão corretamente balanceadas
- ✅ **Suporte a tags singleton**: Reconhece tags que não precisam de fechamento (`<br>`, `<img>`, `<meta>`, etc.)
- ✅ **Contador de tags**: Exibe quantas vezes cada tag aparece no arquivo
- ✅ **Interface gráfica intuitiva**: Facilita a seleção e análise de arquivos
- ✅ **Relatório detalhado**: Mostra resultados da validação em formato de tabela
- ✅ **Tratamento de erros**: Mensagens específicas para diferentes tipos de problemas no HTML

## 🏗️ Estrutura do Projeto

```
ValidarHTML/
├── src/
│   ├── control/           # Lógica de negócio
│   │   ├── HTMLValidator.java      # Validador principal
│   │   ├── LinkedListStack.java    # Implementação de pilha
│   │   ├── LinkedList.java         # Lista encadeada personalizada
│   │   └── TagCounterList.java     # Contador de tags
│   ├── model/             # Modelos de dados
│   │   ├── NodeList.java           # Nó da lista encadeada
│   │   └── CounterTag.java         # Modelo para contagem de tags
│   ├── view/              # Interface gráfica
│   │   ├── ValidateHtmlView.java   # Tela principal
│   │   └── FileChooserView.java    # Seletor de arquivos
│   ├── interfaces/        # Contratos/Interfaces
│   │   └── IStack.java             # Interface da pilha
│   ├── exceptions/        # Exceções customizadas
│   │   ├── EmptyStackException.java
│   │   └── MalformedFileException.java
│   └── init/              # Inicialização
│       └── AppInit.java            # Classe principal
```

## 🔧 Estruturas de Dados Implementadas

### 1. **Pilha (Stack) com Lista Encadeada**
- **Arquivo**: `LinkedListStack.java`
- **Propósito**: Controlar o balanceamento de tags HTML
- **Operações**: `push()`, `pop()`, `isEmpty()`, `top()`

### 2. **Lista Encadeada Personalizada**
- **Arquivo**: `LinkedList.java`
- **Propósito**: Base para implementação da pilha e contador de tags
- **Características**: Implementação genérica com nós encadeados

### 3. **Lista de Contadores**
- **Arquivo**: `TagCounterList.java`
- **Propósito**: Contar e exibir quantas vezes cada tag aparece no HTML

## 🚀 Como Executar

### Pré-requisitos
- Java JDK 8 ou superior
- IDE Java (NetBeans, Eclipse, IntelliJ) ou terminal

### Opção 1: Executar o JAR
```bash
java -jar Trabalho.jar
```

### Opção 2: Compilar e executar
```bash
# Navegar até a pasta do projeto
cd ValidarHTML/src

# Compilar
javac init/AppInit.java

# Executar
java init.AppInit
```

### Opção 3: NetBeans
1. Abrir o projeto na pasta `ValidarHTML/`
2. Executar através da IDE (F6)

## 📱 Como Usar

1. **Iniciar o aplicativo**
2. **Selecionar arquivo HTML**: Clique em "Escolher Arquivo" para selecionar um arquivo HTML
3. **Analisar**: Clique em "Analisar HTML" para iniciar a validação
4. **Visualizar resultados**: 
   - ✅ **Sucesso**: Arquivo válido + tabela com contagem de tags
   - ❌ **Erro**: Mensagem detalhada indicando o problema encontrado

## 🔍 Algoritmo de Validação

O algoritmo utiliza uma **pilha** para verificar o balanceamento das tags:

1. **Percorre** o arquivo linha por linha
2. **Identifica** tags HTML usando expressões regulares
3. **Classifica** tags como:
   - Tags de abertura → `empilha`
   - Tags de fechamento → `desempilha` e verifica correspondência
   - Tags singleton → apenas conta (não afeta a pilha)
4. **Valida** se a pilha está vazia no final
5. **Gera relatório** com contagem de todas as tags encontradas

## 📊 Exemplos de Validação

### ✅ HTML Válido
```html
<!DOCTYPE html>
<html>
  <head>
    <title>Página Válida</title>
  </head>
  <body>
    <h1>Título</h1>
    <p>Parágrafo com <strong>texto forte</strong></p>
    <br>
    <img src="imagem.jpg" alt="Imagem">
  </body>
</html>
```

### ❌ HTML Inválido
```html
<html>
  <head>
    <title>Página Inválida
  </head>
  <body>
    <h1>Título</h2>  <!-- Tag de fechamento incorreta -->
    <p>Parágrafo sem fechamento
  </body>
<!-- Falta fechar </html> -->
```

## 🧪 Casos de Teste

O validador detecta os seguintes erros:

- ❌ **Tags não fechadas**: `<p>texto` (sem `</p>`)
- ❌ **Tags mal aninhadas**: `<strong><em>texto</strong></em>`
- ❌ **Tags de fechamento sem abertura**: `</div>` sem `<div>`
- ❌ **Tags malformadas**: `<div<` ou `>div>`
- ❌ **Arquivo sem tags HTML**: Arquivos de texto puro

## 💡 Conceitos Aplicados

- **Pilha (LIFO)**: Para verificar aninhamento correto de tags
- **Lista Encadeada**: Estrutura base para implementação da pilha
- **Expressões Regulares**: Para identificação de padrões de tags
- **Tratamento de Exceções**: Para diferentes tipos de erro no HTML
- **Padrão Singleton**: Aplicado nas views para gerenciamento de instâncias
- **Programação Orientada a Objetos**: Encapsulamento e modularização

## 🎓 Aprendizados

Este projeto proporcionou experiência prática em:
- Implementação de estruturas de dados fundamentais
- Análise sintática de linguagens de marcação
- Desenvolvimento de interfaces gráficas em Java
- Tratamento robusto de erros e exceções
- Organização e arquitetura de software

---

**Disciplina**: Algoritmos e Estrutura de Dados  
**Instituição**: Fundação Universidade Regional de Blumenau (FURB)  
**Período**: 2025/1
