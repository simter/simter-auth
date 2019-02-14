package tech.simter.auth.dao.r2dbc

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import reactor.test.test
import tech.simter.auth.dao.AccountDao
import tech.simter.exception.UnauthenticatedException
import tech.simter.util.RandomUtils.randomString

/**
 * Test [AccountDaoImpl.match].
 *
 * @author RJ
 */
@SpringBootTest(classes = [UnitTestConfiguration::class])
@ExtendWith(SpringExtension::class)
class MatchMethodImplTest @Autowired constructor(
  private val repository: AccountRepository,
  val dao: AccountDao
) {
  @BeforeEach
  fun clean() {
    repository.deleteAll().test().verifyComplete()
  }

  @Test
  fun notMatch() {
    dao.match(account = randomString(), password = randomString()).test()
      .expectError(UnauthenticatedException::class.java)
      .verify()
  }

  @Test
  fun match() {
    // TODO
  }
}