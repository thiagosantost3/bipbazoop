package com.zoop.bazoop.application.model

import com.zoop.bazoop.business.Contadigital
import com.zoop.bazoop.business.Tipo
import java.time.LocalDate

open class ContaTO {
    var nome: String? = null
    var cpf: String? = null
    var data: LocalDate? = null

        var id: Int? = null
        var Numconta: Int? = null
        var status: String? = null
        var tipo: String? = null
        var Saldo: Int? = null
        var debito:Int? = null
    //todo refatora alterar e todomain para compartilhar a mesma logica
    fun alterar(contadigital: Contadigital) {
        contadigital.also {
            it.status = Contadigital.Status.ABERTA
            it.tipo = Tipo.CONTACOMUN

        }
    }

    fun toDomain(): Contadigital {
        return Contadigital().also {
            it.status = Contadigital.Status.ABERTA
            it.tipo = Tipo.CONTACOMUN
        }
    }
}

    class ContaTOResponse : ContaTO() {
        var contaId: Int = 0

        companion object {
            fun fromConta(contadigital: Contadigital): ContaTOResponse {
                //todo criar cliente to response tecnica todomain
                return ContaTOResponse().also {
                    it.id = contadigital.id
                    it.status = contadigital.status.toString()
                    it.tipo = contadigital.tipo.toString()

                }
            }
        }
    }
