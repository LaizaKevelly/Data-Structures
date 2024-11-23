class FilaDinamica(var tamanho:Int = 10) : Enfileiravel {

    private var ponteiroInicio: NoDuplo? = null;
    private var ponteiroFim: NoDuplo? = null;
    private var quantidade = 0;

    // Metodos principais
    override fun enfileirar(dado: Any?) {
        if (!estaCheia()) {
            val novoNo = NoDuplo(dado)
            if (ponteiroFim != null) {
                ponteiroFim?.proximo = novoNo
            } else {
                ponteiroInicio = novoNo
            }
            novoNo.anterior= ponteiroFim
            ponteiroFim = novoNo
            quantidade++
        } else {
            throw NoSuchElementException("Está cheia")
        }
    }
    override fun desenfileirar(): Any? {
        var dadoTopo: Any? = null
        if (!estaVazia()) {
            dadoTopo = ponteiroInicio?.dado
            ponteiroInicio = ponteiroInicio?.proximo
            if (ponteiroInicio != null) {
                ponteiroInicio?.anterior = null
            } else {
                ponteiroFim = null
            }
            quantidade--
        } else {
            throw NoSuchElementException("Está vazia")
        }
        return dadoTopo
    }
    override fun frente(): Any? {
        var dadoTopo: Any? = null
        if (!estaVazia()) {
            dadoTopo = ponteiroInicio?.dado
        } else {
            throw NoSuchElementException("Está vazia")
        }
        return dadoTopo
    }
    override fun atualizar(dado: Any?) {
        if (!estaVazia()) {
            ponteiroInicio?.dado = dado
        } else {
            throw NoSuchElementException("Está vazia")
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
        var retorno = "["
        var aux = ponteiroInicio
        for (i in 0 until quantidade) {
            retorno += "aux.dado,"
            aux = aux?.proximo
        }
        return "{$retorno}]"
    }
}