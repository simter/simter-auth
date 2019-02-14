package tech.simter.auth.dao

import reactor.core.publisher.Mono
import tech.simter.auth.po.Account
import tech.simter.exception.UnauthenticatedException

/**
 * The dao interface of [Account].
 *
 * @author RJ
 */
interface AccountDao {
  /**
   * Verify whether [password] matches [account].
   *
   * If matched return [Mono.empty], otherwise return [Mono.error] with [UnauthenticatedException].
   */
  fun verify(account: String, password: String): Mono<Void>
}