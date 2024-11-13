interface Amontoavel {
    fun inserir(dado: Long) 	//insert	C
    fun extrair(): Long?		//extract	D
    fun obter(): Long?			//get		R
    fun atualizar(dado: Long)	//update	U

    fun imprimir(): String
    fun estaVazia(): Boolean
    fun estaCheia(): Boolean

    //troca(i: Int, j: Int)
    //pai(indiceFilho: Int): Int
    //filhoEsquerda(indicePai: Int) : Int
    //filhoDireita(indicePai: Int) : Int
    //ajustarAcima(indice: Int)
    //ajustarAbaixo(indice: Int)
    //menor2(a: Int, b: Int): Int
    //menor3(a: Int, b: Int, c: Int): Int

}