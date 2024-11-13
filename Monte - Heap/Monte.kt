class Monte (private val tamanho: Int = 10): Amontoavel {

    private var dados = LongArray(tamanho){0}
    private var ponteiroFim = -1

    fun troca(i: Int, j: Int) { //------------------------------------------------------------
        val temp = dados[i]
        dados[i] = dados[j]
        dados[j] = temp
    }

    fun pai(indiceFilho: Int): Int{
        return (indiceFilho-1)/2
    }

    fun filhoEsquerda(indicePai: Int) : Int{
        return (2 * indicePai + 1)
    }

    fun filhoDireita(indicePai: Int) : Int{
        return (2 * indicePai + 1) + 1
    }

    fun menor3(a: Int, b: Int, c: Int): Int {
        if ((dados[a] < dados[b]) && (dados[a] < dados[c])) {
            return a;
        } else if ((dados[b] < dados[a]) && (dados[b] < dados[c])) {
            return b
        } else {
            return c
        }
    }

    fun menor2(a: Int, b: Int): Int {
        if ((dados[a] < dados[b])) {
            return a;
        } else {
            return b;
        }
    }

    fun ajustarAcima(indice: Int) { // Não recursivo
        var indiceFilho = indice
        var indicePai = pai(indiceFilho)
        while (indiceFilho > 0) {
            if (dados[indicePai] > dados [indiceFilho]) {
                troca(indicePai, indiceFilho)
            } else {
                break
            }
            indiceFilho = indicePai
            indicePai = pai(indiceFilho)
        }
    }

    fun ajustarAbaixo(indice: Int) { //
        var indicePai = indice
        var indiceFilhoEsquerda = filhoEsquerda(indicePai)
        var indiceFilhoDireita = filhoDireita(indicePai)
        val menor = menor3(indicePai, indiceFilhoEsquerda, indiceFilhoDireita)
        if (indicePai != menor) {
            val menorFilho = menor2(indiceFilhoEsquerda, indiceFilhoDireita)
            troca(indicePai, menorFilho)
            ajustarAbaixo(menorFilho)
        }
    }


//---------------------------------------------------------------------------------------------

    override fun inserir(dado: Long) {
        if (!estaCheia()) {
            ponteiroFim = ponteiroFim.inc()
            dados[ponteiroFim] = dado
            ajustarAcima(ponteiroFim)
        } else {
            println("Heap está Cheio!")
        }
    }

    override fun extrair(): Long? {
        var dadoRaiz: Long? = null
        if (!estaVazia()) {
            dadoRaiz = dados[0]
            dados[0] = dados[ponteiroFim]
            ponteiroFim = ponteiroFim.dec()
            ajustarAbaixo(0)
        } else {
            println("Heap está Vazio!")
        }
        return dadoRaiz
    }

    override fun atualizar(dado: Long){
        if (!estaVazia()) {
            dados[0] = dado
            ajustarAbaixo(0)
        } else {
            print("Heap Vazia!")
        }
    }

    override fun imprimir(): String {
        var resultado = "["
        for (i in 0..ponteiroFim) {
            resultado += "${dados[i]}"
            if (i != ponteiroFim)
                resultado += ","
        }
        return "$resultado]"
    }

    override fun estaVazia(): Boolean {
        return (ponteiroFim == -1)
    }

    override fun estaCheia(): Boolean {
        return (ponteiroFim == dados.size - 1)
    }

    override fun obter(): Long? {
        var dadoRaiz: Long? = null
        if (!estaVazia())
            dadoRaiz = dados[0]
        else
            print("Heap Vazia!")

        return dadoRaiz
    }

}