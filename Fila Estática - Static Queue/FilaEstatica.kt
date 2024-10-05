class FilaEstaticaCircular : Enfileiravel {

    constructor(tamanho: Int) {
        private var ponteiroInicio = 0
        private var ponteiroFim = -1
        private var dados: Array<Any?> = arrayOfNulls(tamanho)
        private var quantidade = 0
    }

    override fun atualizar(dado: Any?) {
        if (!estaVazia())
            dados[ponteiroInicio] = dado
        else
            println("A Pilha está Vazia / Stack is Empty")
    }
    override fun enfileirar(dado: Any?) {
        if (!estaCheia()) {
            ponteiroFim++
            if (ponteiroFim == dados.size)
                ponteiroFim = 0
            quantidade++
            dados[ponteiroFim] = dado
        } else {
            println("A Pilha está Cheia / Stack is Full")
        }
    }
    override fun desenfileirar(): Any? {
        var dadoInicio: Any? = null
        if (!estaVazia()) {
            dadoInicio = dados[ponteiroInicio]
            ponteiroInicio++
            if (ponteiroInicio == dados.size)
                ponteiroInicio = 0
            quantidade--
        } else {
            println("A Pilha está Vazia / Stack is Empty")
        }
        return dadoInicio
    }
    override fun frente(): Any? {
        var dadoInicio: Any? = null
        if (!estaVazia()) {
            dadoInicio = dados[ponteiroInicio]
        } else {
            println("A Pilha está Vazia / Stack is Empty")
        }
        return dadoInicio
    }

    override fun estaCheia(): Boolean {
        return quantidade == dados.size
    }
    override fun estaVazia(): Boolean {
        return quantidade == 0
    }
    override fun imprimir(): String {
        var resultado = "["
        var ponteiroAux = ponteiroInicio
        for (i in 0 .. quantidade-1) {
            if (i == quantidade-1)
                resultado += "${dados[ponteiroAux % dados.size]}"
            else
                resultado += "${dados[ponteiroAux % dados.size]},"
            ponteiroAux++
        }
        return "$resultado]"
    }
}