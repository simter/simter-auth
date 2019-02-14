package tech.simter.auth.service

import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import tech.simter.auth.dto.AuthenticatedData

/**
 * The implementation of [AuthenticationService].
 *
 * @author RJ
 */
@Service
class AuthenticationServiceImpl : AuthenticationService {
  override fun login(appId: String, username: String, password: String): Mono<AuthenticatedData> {
    TODO("not implemented")
  }
}