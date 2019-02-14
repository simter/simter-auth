package tech.simter.auth.dao.r2dbc

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono
import tech.simter.auth.dao.AccountDao

/**
 * The Reactive MongoDB implementation of [YmdDao].
 *
 * @author RJ
 */
@Component
class AccountDaoImpl @Autowired constructor(
  private val repository: AccountRepository
) : AccountDao {
  override fun match(account: String, password: String): Mono<Void> {
    return repository.match(account, password)
  }
}