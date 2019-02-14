package tech.simter.auth.rest.webflux

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.TEXT_PLAIN
import org.springframework.web.reactive.function.server.router
import tech.simter.auth.PACKAGE_NAME

/**
 * All configuration for this module.
 *
 * Register a `RouterFunction<ServerResponse>` with all routers for this module.
 * The default context-path of this router can be config by property `module.rest-context-path.simter-auth`.
 *
 * @author RJ
 */
@Configuration("$PACKAGE_NAME.rest.webflux.ModuleConfiguration")
@ComponentScan("$PACKAGE_NAME.rest.webflux")
class ModuleConfiguration @Autowired constructor(
  @Value("\${module.version.simter-auth:UNKNOWN}") private val version: String,
  @Value("\${module.rest-context-path.simter-auth:/auth}") private val contextPath: String
) {
  private val logger = LoggerFactory.getLogger(ModuleConfiguration::class.java)

  init {
    logger.warn("module.version.simter-auth='{}'", version)
    logger.warn("module.rest-context-path.simter-auth='{}'", contextPath)
  }

  /** Register a `RouterFunction<ServerResponse>` with all routers for this module */
  @Bean("$PACKAGE_NAME.rest.webflux.Routes")
  @ConditionalOnMissingBean(name = ["$PACKAGE_NAME.rest.webflux.Routes"])
  fun simterYmdRoutes() = router {
    contextPath.nest {
      // GET /
      GET("/") { ok().contentType(TEXT_PLAIN).syncBody("simter-auth-$version") }
    }
  }
}