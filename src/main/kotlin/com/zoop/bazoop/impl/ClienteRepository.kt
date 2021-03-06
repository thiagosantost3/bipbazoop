package com.zoop.bazoop.impl

import com.zoop.bazoop.domain.ClienteNaoEncontradoException
import model.Cliente
import org.springframework.stereotype.Repository

@Repository
class ClienteRepository {
    private val database: MutableList<Cliente> = ArrayList()

    fun salvar(cliente: Cliente): Cliente {
        database.add(cliente)
        return cliente
    }

    fun obter(clienteId: Int): Cliente {

        return database.firstOrNull { it.id == clienteId } ?: throw ClienteNaoEncontradoException()
    }

    fun excluir(clienteId: Int) {

        if (!database.removeIf { it.id == clienteId }) {
            throw ClienteNaoEncontradoException()
        }
    }

    fun alterar(cliente: Cliente): Cliente {

        return cliente
    }

    fun listar(): List<Cliente> = database
}