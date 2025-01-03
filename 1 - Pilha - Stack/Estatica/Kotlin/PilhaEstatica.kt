class PilhaEstatica : Empilhavel {
    private var ponteiroTopo: Int
    private var dados: Array<Any?> //Declara uma váriavel chamada dados que pode conter qualquer tipo de objeto (Any), incluindo null (?).

    constructor(tamanho : Int){
        dados = arrayOfNulls(tamanho)
        ponteiroTopo = -1
    }

    override fun empilhar(dado: Any?) {
        if (!estaCheia()) {
            ponteiroTopo++
            dados[ponteiroTopo] = dado
        } else {
            println("A Pilha está Cheia / Stack is Full")
        }
    }
    override fun desempilhar(): Any? {
        var dadoTopo: Any? = null
        if (!estaVazia()) {
            dadoTopo = dados[ponteiroTopo]
            ponteiroTopo--
        } else {
            println("A Pilha está Vazia / Stack is Empty")
        }
        return dadoTopo
    }
    override fun espiar(): Any? {
        var dadoTopo: Any? = null
        if (!estaVazia()) {
            dadoTopo = dados[ponteiroTopo]
        } else {
            println("A Pilha está Vazia / Stack is Empty")
        }
        return dadoTopo
    }
    override fun atualizar(dado: Any?) {
        if (!estaVazia())
            dados[ponteiroTopo] = dado
        else
            println("A Pilha está Vazia / Stack is Empty")
    }

    //--------------------------------------------------------------------

    override fun estaCheia(): Boolean{
        return(ponteiroTopo == dados.size - 1)
    }
    override fun estaVazia(): Boolean {
        return(ponteiroTopo == -1)
    }
    override fun imprimir(): String {
        var resultado = "["
        for(i in ponteiroTopo downTo 0) {
            if (i==0){
                resultado += "${dados[i]}"
            } else {
                resultado += "${dados[i]},"
            }
        }
        return "$resultado]"
    }
}