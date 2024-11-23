public interface Empilhavel {
    public void empilhar(Object dado); //push
    public Object desempilhar(); //pop
    public Object espiar(); //peek
    public void atualizar(Object dado);

    public Boolean estaCheia(); //isFull
    public Boolean estaVazia(); //isEmpty
    public String imprimir();
}
