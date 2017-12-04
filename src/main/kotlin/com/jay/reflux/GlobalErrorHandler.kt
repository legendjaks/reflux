package com.jay.reflux

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebExceptionHandler
import reactor.core.publisher.Mono

@Component
class GlobalErrorHandler() : WebExceptionHandler {

  companion object {
    private val log = LoggerFactory.getLogger(GlobalErrorHandler::class.java)
  }

  override fun handle(exchange: ServerWebExchange?, ex: Throwable?): Mono<Void> {

    log.info("inside handle")

    /* Handle different exceptions here */
    when(ex!!) {
      is ClientException -> exchange!!.response.statusCode = HttpStatus.BAD_REQUEST
      is Exception -> exchange!!.response.statusCode = HttpStatus.INTERNAL_SERVER_ERROR
    }

    return Mono.empty()
  }
}

class ClientException(message: String): Exception(message, null, false, true)
