package tech.simter.auth.service.authentication

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig
import tech.simter.auth.service.AuthenticationService
import tech.simter.auth.service.AuthenticationServiceImpl

@SpringJUnitConfig(AuthenticationServiceImpl::class)
class LoginMethodImplTest @Autowired constructor(
  private val service: AuthenticationService
) {
  @Test
  fun test() {

  }
}