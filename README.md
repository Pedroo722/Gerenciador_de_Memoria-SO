# Gerenciamento de Memória

Atividade de gerenciamento de memória para a disciplina de Sistemas Operacionais.

Dupla:
- Pedro Henrique Alexandre
- Vinicius Cavalcante Pequeno

## Descrição da Atividade

**Objetivo**: Implementar um simulador simples de gerenciamento de memória usando paginação.

**Descrição do Problema**: Você deve implementar um simulador de gerenciamento de memória que use paginação para alocar processos na memória física.

O simulador deve ser capaz de:
- Inicializar a memória física
- Alocar páginas de um processo na memória física
- Lidar com a substituição de página usando um algoritmo simples (FIFO, por exemplo)
- Exibir o estado atual da memória física e das tabelas da páginas

**Especificações**:
- Memória Física: Suponha que a memória física tenha 16 quadros, cada um com 4 KB.
- Processos: Cada processo tem um espaço de endereçamento lógico de 16 KB (4 páginas).
- Algoritmo de Substituição: Use o algoritmo FIFO para substituição de páginas.

## Implementação

**Inicialização**:
- Crie uma estrutura de dados para representar a memória física (um array de quadros).
- Crie uma estrutura de dados para representar a tabela de páginas de cada processo.

**Alocação de Páginas**:
- Para cada processo, aloque suas páginas na memória física.
- Se não houver quadros livres, use o algoritmo FIFO para substituir uma página.

**Substituições das Páginas**:
- Implemente o algoritmo FIFO para substituir a página mais antiga quando necessário.

**Substituições das Páginas**:
- Após cada operação de alocação ou substituição, exiba o estado atual da memória física e das tabelas de páginas.
