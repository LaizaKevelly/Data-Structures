public class PilhaEstatica {

    private Object[] dados; //Declara uma váriavel chamada dados que pode conter qualquer tipo de objeto, incluindo null.
    //private Object[] dados = new Object[10];
    private int ponteiroTopo;

    public PilhaEstatica(int tamanho){
        dados = new Object[tamanho];
        ponteiroTopo = -1;
    }

    public void empilhar(Object dado){
        if (!estaCheia()) {
            ponteiroTopo++;
            dados[ponteiroTopo] = dado;
        } else {
            System.out.println("A Pilha está Cheia / Stack is Full");
        }
    }
    public Object desempilhar(){
        Object dadoTopo = dados[ponteiroTopo];
        if (!estaVazia()) {
            dados[ponteiroTopo] = null;
            ponteiroTopo--;
        } else {
            System.out.println("A Pilha está Vazia / Stack is Empty");
        }
        return dadoTopo;
    }
    public Object espiar(){
        Object dadoTopo = null;
        if (!estaVazia()) {
            dadoTopo = dados[ponteiroTopo];
        } else {
            System.out.println("A Pilha está Vazia / Stack is Empty");
        }
        return dadoTopo;
    }
    public void atualizar(Object dado){
        if (!estaVazia()) {
            dados[ponteiroTopo] = dado;
        } else {
            System.out.println("A Pilha está Vazia / Stack is Empty");
        }
    }

    //--------------------------------------------------------------------
    public Boolean estaCheia(){
        return ponteiroTopo == dados.length - 1;
    }

    public Boolean estaVazia(){
        return ponteiroTopo == -1;
    }

    public String imprimir(){
        String resultado = "[";
        for(int i=ponteiroTopo; i > 0; i--) {
            if (i==0){
                resultado += "${dados[i]}";
            } else {
                resultado += "${dados[i]},";
            }
        }
        return "$resultado]";
    }
}
