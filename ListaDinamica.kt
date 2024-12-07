class ListaDinamica(val tamanho: Int) : Listavel {
    private var ponteiroInicio: NoDuplo? = null
    private var ponteiroFim: NoDuplo? = null
    private var quantidade = 0

    //PRINCIPAIS
    override fun inserir(dado: Any?, posicao: Int) {
        var auxvaiqueprecisa = ponteiroInicio
        if (!estaCheia()) {
            if (posicao > 0 && posicao <= quantidade) {
                for (i in 0 until posicao) {
                    auxvaiqueprecisa = auxvaiqueprecisa?.proximo
                }

                var novoNo = NoDuplo(dado)
                var ant: Any? = null
                if (auxvaiqueprecisa != null) {
                    ant = auxvaiqueprecisa.anterior
                } else {
                    ant = ponteiroFim
                }
                var prox = auxvaiqueprecisa

                //novoNo.anterior = ant
                //ant.proximo = novoNo
                //novoNo.proximo = prox
                //prox.anterior = novoNo
                //quantidade++


                if (ant != null) {
                    ant.proximo = novoNo
                } else {
                    ponteiroInicio = novoNo
                }
                if (prox != null) {
                    prox.anterior = novoNo
                } else {
                    ponteiroFim = novoNo
                }
                novoNo.anterior = ant
                novoNo.proximo = prox

                quantidade++
            } else {
                throw IndexOutOfBoundsException ("Esse index aí n sei n hein")
            }
        } else {
            throw NoSuchElementException ("Não tem como, esta cheia :c")
        }
    }
    override fun anexar(dado: Any?) {
        if (!estaCheia()) {
            val novoNo = NoDuplo(dado);
            ponteiroFim?.proximo = novoNo
            novoNo.anterior = ponteiroFim
            ponteiroFim = novoNo
            quantidade++
        }
    }
    override fun atualizar(dado: Any?, posicao: Int) {
        if (!estaVazia()) {
            var auxvaiqueprecisa = ponteiroInicio
            for (i in 0 until posicao) {
                auxvaiqueprecisa = auxvaiqueprecisa?.proximo
            }
            auxvaiqueprecisa?.dado = dado
        }
    }
    override fun apagar(posicao: Int): Any? {
        var auxvaiqueprecisa = ponteiroInicio
        if (!estaVazia()) {
            for (i in 0 until posicao) {
                auxvaiqueprecisa = auxvaiqueprecisa?.proximo
            }
            var ant = auxvaiqueprecisa?.anterior
            var prox = auxvaiqueprecisa?.proximo

            //--------------------
            if (ant != null) {
                ant.proximo = prox
            } else {
                ponteiroInicio = ponteiroInicio?.proximo
            }
            if (prox != null) {
                prox.anterior = ant
            } else {
                ponteiroFim = ponteiroFim?.anterior
            }
            quantidade --
            //--------------------
        }
        return auxvaiqueprecisa?.dado
    }
    override fun limpar() {
        ponteiroInicio = null
        ponteiroInicio = null
        quantidade = 0
    }

    override fun selecionar(posicao: Int): Any? {
        //var dadoTemp:Any? = null
        var resultado = ponteiroInicio
        if (!estaVazia()) {
            for (i in 0 until posicao) {
                resultado = resultado?.proximo
            }
            //dadoTemp = aux?.dado
        }
        return resultado?.dado //________________________________________________testar
    }
    override fun selecionarTodos(): Array<Any?> {
        var auxvaiqueprecisa = ponteiroInicio
        var resultado: Array<Any?> = arrayOfNulls(quantidade)
        if (!estaVazia()) {
            for (i in 0 until quantidade) {
                resultado[i] = auxvaiqueprecisa?.dado
                auxvaiqueprecisa = auxvaiqueprecisa?.proximo
            }
        }
        return resultado
    }

    //AUX
    override fun estaCheia(): Boolean {
        return tamanho == quantidade
    }
    override fun estaVazia(): Boolean {
        return quantidade == 0
    }
    override fun imprimir(): String {
        var auxvaiqueprecisa = ponteiroInicio
        var resultado :String = "["
        for (i in 0 until quantidade) {
            resultado += auxvaiqueprecisa?.dado
            if (i != quantidade - 1) {
                resultado += ","
            }
            auxvaiqueprecisa = auxvaiqueprecisa?.proximo
        }
        return "$resultado]"
    }
}