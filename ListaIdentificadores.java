public class ListaIdentificadores {
    private static class Item {
        int id;
        Item proximo;

        Item(int id) {
            this.id = id;
            this.proximo = null;
        }
    }

    private Item sentinela;
    private Item tail;
    private int tamanho;

    public ListaIdentificadores() {
        this.sentinela = new Item(-1);
        this.tail = this.sentinela;
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
        Item novoItem = new Item(id);
        this.tail.proximo = novoItem;
        this.tail = novoItem;
        this.tamanho++;
    }

    public boolean contem(int id) {
        Item atual = this.sentinela.proximo;
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
        Item atual = this.sentinela.proximo;
        for (int i = 0; i < index; i++) {
            atual = atual.proximo;
        }
        return atual.id;
    }
    public void limpar() {
    sentinela.proximo = null;
    tail = sentinela;
    tamanho = 0;
}


}
