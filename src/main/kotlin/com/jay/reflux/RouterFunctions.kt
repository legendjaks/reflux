package com.jay.reflux

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.router
import org.springframework.web.server.adapter.WebHttpHandlerBuilder

@Configuration
class RoutesConfiguration {

  @Autowired
  private lateinit var testService: TestService

  @Autowired
  private lateinit var globalErrorHandler: GlobalErrorHandler

  @Bean
  fun routerFunction():

    RouterFunction<ServerResponse> = router {
    ("/test").nest {

      GET("/") {
        ServerResponse.ok().body(testService.test())
      }
    }
  }

  //Not working
  //@Bean
  fun webHandler() = WebHttpHandlerBuilder
    .webHandler(RouterFunctions.toWebHandler(routerFunction()))
    .exceptionHandler(globalErrorHandler)
    .build()
}
