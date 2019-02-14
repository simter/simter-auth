package tech.simter.auth.dao.r2dbc

import reactor.core.publisher.Mono

/**
 * @author RJ
 */
interface CustomizedAccountRepository {
  fun match(account: String, password: String): Mono<Void>
}