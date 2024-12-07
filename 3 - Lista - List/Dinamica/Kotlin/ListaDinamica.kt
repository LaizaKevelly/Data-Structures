class ListaDinamica(val tamanho: Int): Listavel {
    private var quantidade = 0
    private var fim: NoDuplo? = null
    private var inicio: NoDuplo? = null

    //PRINCIPAIS
    override fun inserir(dado: Any?, posicao: Int) {
        var aux = inicio
        if (!estaVazia()) {
            if (posicao >= 0 && posicao < quantidade) {
                for (i in 0 until posicao) {
                    aux = aux?.proximo
                }
                val novoNo = NoDuplo(dado)
                val prox = aux
                var ant: Any? = null
                if (aux != null) {
                    ant = aux.anterior
                } else {
                    ant = fim
                }
                //----------------------- Lógica
                //ant?.proximo = novoNo
                //prox?.anterior = novoNo
                //novoNo.proximo = prox
                //novoNo.anterior = ant


                prox?.anterior = novoNo
                novoNo.proximo = prox
                novoNo.anterior = ant

                if (ant != null) {
                    ant.proximo = novoNo
                } else {
                    inicio = novoNo
                }
                //-----------------------
            } else {
                throw IndexOutOfBoundsException ("")
            }
        } else {
            throw NoSuchElementException("")
        }
    }
    override fun anexar(dado: Any?) {
        if(!estaCheia()) {
            val noAux = NoDuplo(dado)
            noAux.anterior = fim
            fim?.proximo = noAux
            fim = noAux
            quantidade++
        }

    }
    override fun atualizar(dado: Any?, posicao: Int) {
        if (!estaVazia()) {
            if (posicao >= 0 && posicao < quantidade) {
                var aux = inicio
                for (i in 0..posicao) {
                    aux = aux?.proximo
                }
                aux?.dado = dado
            } else
                throw IndexOutOfBoundsException("")
        } else {
            throw NoSuchElementException("")
        }
    }
    override fun apagar(posicao: Int): Any? {
        var temp: Any? = null
        if(!estaVazia()) {
            if (posicao < quantidade && posicao >= 0) {
                var aux = inicio
                for (i in 0 until posicao) {
                    aux = aux?.proximo
                }
                temp = aux
                val ant = aux?.anterior
                val prox = aux?.proximo

                //----------------------- Lógica
                // ant.proximo = prox
                // prox.anterior = ant
                // quantidade--

                if (ant != null) {
                    ant.proximo = prox
                } else
                    inicio = inicio?.proximo
                    quantidade--
                if (prox != null) {
                    prox.anterior = ant
                } else
                    fim = fim?.anterior
                    quantidade--
                //-----------------------
            } else {
                throw IndexOutOfBoundsException("")
            }
        } else {
            throw NoSuchElementException("")
        }
        return temp
    }
    override fun limpar() {}

    override fun selecionar(posicao: Int): Any? {
        var dadoTemp:Any? = null
        if (!estaVazia()) {
            if (posicao >= 0 && posicao < quantidade) {
                var aux = inicio
                for (i in 0 until posicao) {
                    aux = aux?.proximo
                }
                dadoTemp = aux?.dado
            }
        }
        return dadoTemp
    }
    override fun selecionarTodos(): Array<Any?> {
        val arrayDados: Array<Any?> = arrayOfNulls(quantidade)
        var aux = inicio
        if (!estaVazia()) {
            for (i in 0 ..< quantidade) { // ..< = until (0 até 4)
                arrayDados[i] = aux?.dado
                aux = aux?.proximo
            }
        }
        return arrayDados
    }
    override fun ordenar() {

    }

    //AUXILIARES
    override fun estaCheia(): Boolean {
        return tamanho == quantidade
    }
    override fun estaVazia(): Boolean {
        return 0 == quantidade
    }
    override fun imprimir(): String {
        var aux = inicio
        var resultado = "["
        for (i in 0 until quantidade) {
            resultado += aux?.dado
            if (i != quantidade-1) resultado += ","
            aux = aux?.proximo
        }
        return "$resultado]"
    }

}