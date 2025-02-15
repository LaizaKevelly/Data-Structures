interface Arborizavel {
    fun inserir(dado: Any?)
    fun apagar(dado: Any?): NoTriplo?
    fun limpar()
    fun existe(dado: Any?): Boolean
    fun buscar(dado: Any?): NoTriplo?

    //impressao
    fun preOrdem(): String?
    fun emOrdem(): String?
    fun posOrdem(): String?
}