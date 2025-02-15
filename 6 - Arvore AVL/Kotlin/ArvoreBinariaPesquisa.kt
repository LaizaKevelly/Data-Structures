class ArvoreBinariaPesquisa: Arborizavel {

    var raiz: NoTriplo? = NoTriplo()

    override fun inserir(dado: Any?) {
        if(raiz?.dado == null){
            raiz?.dado = dado
        } else {
            var novoNo = NoTriplo(dado)
            var aux = raiz
            while (aux != null){
                if((aux.dado as Int) < (dado as Int)){
                    //preciso ir para direita
                    //existe direita?
                    if(aux.direita != null){ //sim = eu vou
                        aux = aux.direita
                    } else { //insiro aqui
                        aux.direita = novoNo
                        novoNo.genitor = aux
                    }
                } else {
                    //preciso ir para esquerda
                    //existe esquerda
                    if(aux.esquerda != null){ //sim = eu vou
                        aux = aux.esquerda
                    } else { //insiro aqui
                        aux.esquerda = novoNo
                        novoNo.genitor = aux
                    }
                }
            }
        }
    }

    override fun existe(dado: Any?): Boolean {
        var aux = raiz
        while (aux != null){
            if(aux.dado == dado){
                return true
            } else if(aux.dado > dado){
                aux = aux.direita
            } else {
                aux = aux.esquerda
            }
        }
        return false
    }

    override fun buscar(dado: Any?): NoTriplo? {
        var aux = raiz
        while (aux != null){
            if(aux.dado == dado){
                return aux
            } else if(aux.dado > dado){
                aux = aux.direita
            } else {
                aux = aux.esquerda
            }
        }
        return null
    }

    override fun limpar() {
        raiz = NoTriplo()
    }

    override fun apagar(dado: Any?): NoTriplo? {
        //identificar se o nó que quero apagar
        val noAuxiliar = buscar(dado)
            if(noAuxiliar?.esquerda != null && noAuxiliar.direita == null){
                apagarDoisFilhos(noAuxiliar)
            } else if((noAuxiliar?.esquerda == null && noAuxiliar?.direita != null) || (noAuxiliar?.esquerda != null && noAuxiliar?.direita == null)){
                apagarUmFilho(noAuxiliar)
            } else {
            apagarSemFilhos(noAuxiliar)
            }
    }

    private fun apagarSemFilhos(no: NoTriplo?){
        val pai = no?.genitor
        if(pai?.esquerda == no){
            pai?.esquerda = null
        } else {
            pai?.direita = null
        }
    }

    private fun apagarUmFilho(no: NoTriplo?){
        val avo = no?.genitor
        var filho: NoTriplo? = null
            if(no?.esquerda != null){
                filho = no.esquerda
            } else{
                filho = no?.direita
            }
        filho?.genitor = avo
        if(avo?.esquerda == no){
            avo?.esquerda = filho
        } else {
            avo?.direita = filho
        }
    }

    fun maiorNoDaEsquerda(no: NoTriplo?): NoTriplo?{
        var aux = no?.esquerda

        while (aux?.direita != null){
            aux = aux.direita
        }
        return aux
    }

    fun menorNoDaDireita(no: NoTriplo?): NoTriplo?{
        var aux = no?.direita

        while (aux?.esquerda != null){
            aux = aux.esquerda
        }
        return aux
    }

    private fun apagarDoisFilhos(no: NoTriplo?){
        val maiorEsquerda = maiorNoDaEsquerda(no)
        no?.dado = maiorEsquerda?.dado
        apagar(maiorEsquerda)
    }

    override fun preOrdem(): String? {
        return preOrdemRecursivo(raiz)
    }

    private  fun preOrdemRecursivo(no: NoTriplo?): String?{
        if(no != null){
            return no.dado + preOrdemRecursivo(no.esquerda) + preOrdemRecursivo(no.direita)
        } else {
            return null
        }

    }

    override fun emOrdem(): String? {
        return emOrdemRecursivo(raiz)
    }

    private fun emOrdemRecursivo(no: NoTriplo?): String?{
        if(no != null){
            return emOrdemRecursivo(no.esquerda) + no.dado + emOrdemRecursivo(no.direita)
        } else {
            return null
        }
    }

    override fun posOrdem(): String? {
        return posOrdemRecursivo(raiz)
    }

    private fun posOrdemRecursivo(no: NoTriplo?): String?{
        if(no != null){
            return posOrdemRecursivo(no.esquerda) + posOrdemRecursivo(no.direita) + no.dado
        } else {
            return null
        }
    }


}

