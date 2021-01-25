package com.zoop.bazoop.application.controller

import com.zoop.bazoop.application.facade.ContaFacade
import com.zoop.bazoop.application.model.ClienteTO
import com.zoop.bazoop.application.model.ClienteTOResponse
import com.zoop.bazoop.application.model.ContaTO
import com.zoop.bazoop.application.model.ContaTOResponse
import com.zoop.bazoop.application.model.MessageTO
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
@RequestMapping("/bazoop/contas", produces = [MediaType.APPLICATION_JSON_VALUE])
class ContaController {

    @Autowired
    lateinit var contafacade: ContaFacade
    //Todo criar um controlor de contas sempre vou precisar do do indentificardor do cliente

    @PostMapping("/criarconta")
    fun criarconta(@RequestBody contadigital: Contadigital): ResponseEntity<Contadigital> {

        return ResponseEntity.ok(contafacade.criarconta(contadigital))
    }
//TODO trocartudopara contas

    @GetMapping("/{id}")
    fun obterConta(@PathVariable id: Int): ResponseEntity<ContaTOResponse?>? {
        return contafacade.obterConta(id)?.let { ResponseEntity.ok(it) }
    }

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Int): ResponseEntity<MessageTO> {
        contafacade.deletar(id)
        return ResponseEntity.ok(MessageTO("Cliente excluido com sucesso!!"))
    }

    //put alterar
    @PutMapping("/{id}")
    fun alterarConta(@PathVariable id: Int, @RequestBody contadigital: ContaTO): ResponseEntity<ContaTOResponse?>? {

        return this.contafacade.alterarConta(id, contadigital)?.let { ResponseEntity.ok(it) }
    }

    @GetMapping
    fun listarContas(): ResponseEntity<List<ContaTOResponse>> {
        return ResponseEntity.ok(contafacade.obterTodosContas())
    }
}
