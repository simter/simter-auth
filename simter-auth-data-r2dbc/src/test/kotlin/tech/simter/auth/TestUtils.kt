package tech.simter.auth

import tech.simter.auth.po.Account
import tech.simter.util.RandomUtils.nextId
import tech.simter.util.RandomUtils.randomString

/**
 * Test utils.
 *
 * @author RJ
 */
object TestUtils {
  fun randomAccount(
    id: Long = nextId().toLong(),
    username: String = randomString(),
    password: String = randomString()
  ): Account {
    return Account(
      id = id,
      status = 0,
      username = username,
      password = password
    )
  }
}