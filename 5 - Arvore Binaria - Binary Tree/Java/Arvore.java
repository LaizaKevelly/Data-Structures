//Não está completa ainda
public class Arvore {
    private Folha folha;
    private Arvore esquerda;
    private Arvore direita;

    public Arvore() {
        this.folha = null;
        this.esquerda = null;
        this.direita = null;
    }

    public Arvore(Folha folha) {
        this.folha = folha;
        this.esquerda = null;
        this.direita = null;
    }

    public boolean isEmpty() {
        return this.folha == null;
    }

    public void inserir(Folha folha) {
        if (isEmpty()) {
            this.folha = folha;
        } else {

        }
    }

}
