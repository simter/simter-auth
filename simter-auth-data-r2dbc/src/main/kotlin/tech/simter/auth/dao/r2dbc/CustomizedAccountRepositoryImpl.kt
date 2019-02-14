package tech.simter.auth.dao.r2dbc

import io.r2dbc.spi.Connection
import io.r2dbc.spi.ConnectionFactory
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

/**
 * @author RJ
 */
@Component
class CustomizedAccountRepositoryImpl @Autowired constructor(
  private val connectionFactory: ConnectionFactory
) : CustomizedAccountRepository {
  private val logger = LoggerFactory.getLogger(CustomizedAccountRepository::class.java)

  private fun connection(): Mono<Connection> {
    return Mono.from(connectionFactory.create())
  }

  override fun match(account: String, password: String): Mono<Void> {
    return this.connection()
      .flatMap {
        Mono.from(
          it.createStatement("select 0 from st_account where status = $1 and username = $2 and password = $3")
            .bind("$1", 0) // only active account
            .bind("$2", account)
            .bind("$3", password)
            .execute()
        )
      }.then()
  }
}