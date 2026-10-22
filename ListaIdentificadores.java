public class ListaIdentificadores {
    private static class No {
        int id;
        No proximo;

        No(int id) {
            this.id = id;
            this.proximo = null;
        }
    }

    private No inicio; // Sentinela
    private No fim;    // Tail
    private int tamanho;

    public ListaIdentificadores() {
        this.inicio = new No(-1); // Nó sentinela
        this.fim = this.inicio;
        this.tamanho = 0;
    }
public boolean estaVazia() {
        return this.tamanho == 0;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public void inserir(int id) {
        if (contem(id)) return; 
        No novoNo = new No(id);
        this.fim.proximo = novoNo;
        this.fim = novoNo;
        this.tamanho++;
    }

    public boolean contem(int id) {
        No atual = this.inicio.proximo;
        while (atual != null) {
            if (atual.id == id) {
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }

    public int obter(int index) {
        if (index < 0 || index >= tamanho) throw new IndexOutOfBoundsException("Índice inválido");
        No atual = this.inicio.proximo;
        for (int i = 0; i < index; i++) {
            atual = atual.proximo;
        }
        return atual.id;
    }
    public void limpar() {
    inicio.proximo = null;
    fim = inicio;
    tamanho = 0;
}


}
