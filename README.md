# Morse Code Binary Tree  
Implementação em Java de uma **Árvore Binária de Código Morse** para **codificar** texto em pontos e traços e **decodificar** sequências de Morse de volta para caracteres. Projeto acadêmico voltado ao domínio de árvores e travessias, com foco em autoria, clareza e prova de conhecimento.

<p align="center">
  <img src="https://img.shields.io/badge/Java-17%2B-blue" />
  <img src="https://img.shields.io/badge/Build-javac%2Fjar-informational" />
  <img src="https://img.shields.io/badge/License-MIT-success" />
</p>

---

## Objetivos do projeto  
* Construir uma árvore binária onde cada caminho a partir da raiz representa um caractere em **Morse**  
  ponto (.) = **esquerda**  
  traço (-) = **direita**  
* Suportar **decodificação** de mensagens Morse em texto alfanumérico  
* Suportar **codificação** de texto em sequência Morse, usando um **índice reverso** (mapa letra→morse)  
* Demonstrar travessias em árvore e análise de complexidade no contexto de estruturas dinâmicas

---

## Funcionalidades  
* **Decodificar**: converte uma string Morse (com separador de letras e palavras) para texto  
* **Codificar**: converte texto para a notação Morse padronizada  
* **Construção dinâmica** da árvore a partir de uma tabela de pares caractere→morse  
* **Validações**: ignora símbolos não mapeados opcionalmente ou sinaliza erro de mapeamento  
* **Relatórios**: estatísticas de nós, altura da árvore e validação de integridade

---

## Estruturas de dados  
**NoMorse**  
* `char valor`  
* `NoMorse esquerda` para ponto (.)  
* `NoMorse direita` para traço (-)

**MorseTree**  
* `NoMorse raiz`  
* `void inserir(char c, String morse)` desce pela árvore criando nós conforme '.' e '-'  
* `char decodificarLetra(String morse)` percorre a partir da raiz e retorna o caractere no nó terminal  
* `String codificarLetra(char c)` usa mapa reverso para obter a sequência Morse  
* `boolean contem(String morse)` checa se o caminho existe e termina em nó válido  
* `int altura()` computa altura da árvore  
* `int contarNos()` total de nós alocados

**MorseCodec**  
* `String decodificar(String mensagemMorse, String sepLetra, String sepPalavra)`  
* `String codificar(String texto, String sepLetra, String sepPalavra)`  
* `Map<Character,String> indiceReverso` para codificação em O(1)

Complexidade  
* Busca por letra via árvore: O(L), onde L é o comprimento da sequência Morse da letra  
* Codificação com índice reverso: O(1) por letra após construção do mapa  
* Construção da árvore: O(Σ Li), Li é o comprimento Morse de cada símbolo inserido


---

## Separadores e normalização  
* Separador de **letras** padrão: espaço  
* Separador de **palavras** padrão: `/`  
* Entrada de texto é normalizada para maiúsculas e caracteres acentuados podem ser removidos ou mapeados conforme configuração  
* Símbolos sem mapeamento podem ser ignorados ou marcados com `?` conforme flag de validação

---

## Testes recomendados  
**MorseTreeTest**  
* Inserção e decodificação de letras isoladas  
* Caminhos inválidos retornam erro ou caractere sentinela

**MorseCodecTest**  
* Decodificação de palavras e frases  
* Codificação round-trip: `texto == decodificar(codificar(texto))` para subconjunto mapeado  
* Manuseio de números de 0 a 9


---

## Diagrama conceitual  
```mermaid
flowchart TD
  R[(Raiz)]
  R -- "." --> E1[No .]
  R -- "-" --> D1[No -]
  E1 -- "." --> E2
  E1 -- "-" --> D2
  D1 -- "." --> E3
  D1 -- "-" --> D3
  %% Caminhos . e - formam letras nos nós terminais
