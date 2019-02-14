package tech.simter.auth.rest.webflux

import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.function.server.HandlerFunction
import org.springframework.web.reactive.function.server.RouterFunction

/**
 * All configuration for this module.
 *
 * Will auto create a [WebTestClient] instance to use by injected.
 * Because [WebTestClient] need [RouterFunction] config, so for pure [HandlerFunction] test,
 * need to config a router like bellow :
 *
 * ```
 * @SpringJUnitConfig(UnitTestConfiguration::class, MyHandler::class)
 * @WebFluxTest
 * class MyHandlerTest @Autowired constructor(
 *   private val client: WebTestClient,
 *   private val myService: MyService
 * ) {
 *   @Configuration
 *   class Cfg {
 *     @Bean
 *     fun theRoute(handler: MyHandler): RouterFunction<ServerResponse> = route(REQUEST_PREDICATE, handler)
 *   }
 *
 *   @Test
 *   fun testMethod() {
 *     ...
 *   }
 * }
 * ```
 *
 * @author RJ
 */
@Configuration
@EnableWebFlux
@Import(
  // auto active Jackson config : create a ObjectMapper instance
  JacksonAutoConfiguration::class,
  // see simter-reactive-web/README.md : global register java-time serializer and deserializer
  tech.simter.reactive.web.webflux.WebFluxConfiguration::class
)
class UnitTestConfiguration