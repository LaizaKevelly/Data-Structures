class PilhaDinamica(var tamanho: Int) : Empilhavel{
    private var ponteiroTopo: NoDuplo? = null
    private var quantidade = 0

    // Metodos principais
    override fun empilhar(dado: Any?) {
        if (!estaCheia()) {
            val novoNo = NoDuplo(dado)
            if (!estaVazia()) {
                ponteiroTopo?.proximo = novoNo
            }
            novoNo.anterior = ponteiroTopo
            ponteiroTopo = novoNo
            quantidade++
        } else {
            println("Está cheia")
        }
    }
    override fun desempilhar(): Any? {
        var dadoTopo: Any? = ponteiroTopo?.dado
        if (!estaVazia()) {
            ponteiroTopo = ponteiroTopo?.anterior
            if (ponteiroTopo != null) {
                ponteiroTopo?.proximo = null
            }
            quantidade--
        } else {
            println("Está vazia")
        }
        return dadoTopo
    }
    override fun espiar(): Any? {
        var dadoTopo: Any? = null
        if (!estaVazia()) {
            dadoTopo = ponteiroTopo?.dado
        } else {
            println("Está vazia")
        }
        return dadoTopo
    }
    override fun atualizar(dado: Any?) {
        if (!estaVazia()) {
            ponteiroTopo?.dado = dado
        } else {
            println("Está vazia")
        }
    }

    // Metodos auxiliares
    override fun estaCheia(): Boolean {
        return quantidade == tamanho
    }
    override fun estaVazia(): Boolean {
        return quantidade == 0
    }
    override fun imprimir(): String {
        //Descer a pilha a partir do topo
        var aux = ponteiroTopo
        var retorno = "["
        while (aux?.anterior != null) {
            retorno += aux.dado
            aux = aux?.anterior
        }
        return "{$retorno}]"
    }
}