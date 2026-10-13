# ProjetoAED
Agência de relacionamento

=====================================================
SISTEMA DE GERENCIAMENTO DE AGÊNCIA DE RELACIONAMENTO
=====================================================

GRUPO:
- Aluno : [CECILIA VARGAS BITENCOURT]


DESCRIÇÃO DO PROJETO:
Aplicação desenvolvida em Java para automatizar a identificação de 
potenciais pares (companheiros) em uma agência de relacionamento, 
utilizando exclusivamente estruturas de dados implementadas do zero 
(listas simplesmente encadeadas com sentinela e tail), sem o uso das 
coleções prontas do Java (como ArrayList ou LinkedList).

ESTRUTURA DOS MÓDULOS:
- Candidato.java: TAD que representa o candidato, suas áreas de interesse e sua lista de potenciais companheiros.
- ListaIdentificadores.java: TAD que implementa a lista encadeada com sentinela e tail para armazenar identificadores.
- GerenciadorAgencia.java: Módulo responsável pela leitura do arquivo de dados, processamento das regras de negócio e execução das tarefas.
- GeradorDados.java: Programa auxiliar para gerar automaticamente o arquivo de teste `candidatos.txt`.
- Main.java: Classe principal contendo a interface textual interativa baseada em menu.

INSTRUÇÕES DE COMPILAÇÃO E EXECUÇÃO:


1. Compilação:
   Abra o terminal/prompt de comando na pasta onde estão os arquivos-fonte (.java) e execute:
   
   javac *.java

2. Execução:
   Após compilar com sucesso, execute o programa principal com o comando:
   
   java Main

3. Arquivo de Entrada:
   O sistema lê automaticamente o arquivo `candidatos.txt` gerado pelo programa auxiliar. Caso deseje modificar os dados de entrada, certifique-se de manter o formato especificado no enunciado do trabalho.
