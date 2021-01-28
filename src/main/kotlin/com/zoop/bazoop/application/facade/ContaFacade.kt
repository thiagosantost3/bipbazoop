package com.zoop.bazoop.application.facade

import com.zoop.bazoop.application.model.ClienteTOResponse
import com.zoop.bazoop.application.model.ContaTO
import com.zoop.bazoop.application.model.ContaTOResponse
import com.zoop.bazoop.business.Contadigital
import com.zoop.bazoop.impl.ContaRepository
import model.Cliente
import org.springframework.beans.factory.annotation.Autowired
import kotlin.random.Random

class ContaFacade {
    @Autowired
    lateinit var contarepository: ContaRepository
    fun obterTodosContas(): List<ContaTOResponse> {


        return contarepository.listar().map { ContaTOResponse.fromConta(it) }

    }
    //criar conta
    fun criarconta(contadigital: Contadigital): Contadigital {

        var saldo: Long = 0
        var id: Long = Random.nextLong(100000000)
        var Numconta: Int = java.util.Random().nextInt(1000) + 1

        println("""seu saldo ${saldo}  seu id $id seu numConta $Numconta""")
        return contadigital
    }
    fun obterConta(contaId: Int): ContaTOResponse? {
        return contarepository.obter(contaId)?.let {
            ContaTOResponse.fromConta(
                it
            )
        }
    }

    //deletar cliente
    fun deletar(id: Int) {
        contarepository.excluir(id)
    }

    fun alterarConta(id: Int, request: ContaTO): ContaTOResponse? {
        val conta = contarepository.obter(id)
        if (conta != null) {
            request.alterar(conta)
        }
        contarepository.alterar(conta)

        return conta?.let { ContaTOResponse.fromConta(it) }
    }
}