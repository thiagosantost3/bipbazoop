package com.zoop.bazoop.application.controller

import com.zoop.bazoop.application.facade.ClienteFacade
import com.zoop.bazoop.application.model.ClienteTO
import com.zoop.bazoop.application.model.ClienteTOResponse
import com.zoop.bazoop.business.Contadigital
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/bazoop/clientes", produces = [MediaType.APPLICATION_JSON_VALUE])
class ClienteController {
    @Autowired
    lateinit var facade: ClienteFacade
// refatora

    @PostMapping
    fun criarCliente(@RequestBody cliente: ClienteTO): ResponseEntity<ClienteTOResponse> {

        return ResponseEntity.ok(facade.criarCliente(cliente))
    }

    /*  @PostMapping("/criarconta")
      fun criarconta(@RequestBody contadigital: Contadigital): ResponseEntity<Contadigital> {

          return ResponseEntity.ok(facade.criarconta(contadigital))
      }
  */
    @GetMapping("/{id}")
    fun obterCliente(@PathVariable id: Int): ResponseEntity<ClienteTOResponse> {
        return ResponseEntity.ok(facade.obterCliente(id))
    }

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Int): ResponseEntity<ClienteTOResponse> {

        return ResponseEntity.ok(facade.deletar(id))
    }

    //put alterar
    @PutMapping("/alterarcliente")
    fun alterarcliente(cliente: ClienteTO): ResponseEntity<ClienteTOResponse> {

        return ResponseEntity.ok(facade.alterarCliente(cliente))
    }

    @GetMapping("/lista")
    fun listarClientes(): ResponseEntity<List<ClienteTO>> {
        return ResponseEntity.ok(facade.obterTodosClientes())
    }
}

// infra estrutura do jsom