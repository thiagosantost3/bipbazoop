package com.zoop.bazoop.impl

import model.Cliente
import org.springframework.stereotype.Repository

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

    fun listar(): List<Cliente> = database
}