package com.jay.reflux

import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class TestService {

  fun test(): Mono<String> {

    throw ClientException("sample exception")

    //return Mono.just("sample data")
  }
}
