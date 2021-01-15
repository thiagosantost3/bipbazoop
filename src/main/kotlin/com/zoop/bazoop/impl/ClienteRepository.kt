package com.zoop.bazoop.impl

import com.zoop.bazoop.application.model.ClienteTOResponse
import model.Cliente
import model.Cpf
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
class ClienteRepository {
    private val database: MutableList<Cliente> = ArrayList()

    fun salvar(cliente: Cliente): Cliente {
        database.add(cliente)
        return cliente
    }

    fun obter(clienteId: Int): Cliente? {

        return database.firstOrNull { it.id == clienteId }
    }

    fun excluir(clienteId: Int): Cliente {
        database.firstOrNull { it.id == clienteId }
        return database.removeAt(clienteId)
    }
    fun alterar(cliente: Cliente): Cliente {
        database.firstOrNull { it.id == it.id }
        return Cliente().also {
            it.cpf = Cpf("")
            it.data = LocalDate.now()
            it.nome = ""
        }
    }

    fun listar(): List<Cliente> = database
}