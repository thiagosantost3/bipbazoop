package com.zoop.bazoop.infra

import com.zoop.bazoop.domain.ClienteNaoEncontradoException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandlerAdvice {
    @ExceptionHandler(ClienteNaoEncontradoException::class)
    fun tratarRecursoNaoEncontrado(exception: ClienteNaoEncontradoException): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.message)
    }
}