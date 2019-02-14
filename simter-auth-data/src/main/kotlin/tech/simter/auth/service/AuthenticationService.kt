package tech.simter.auth.service

import reactor.core.publisher.Mono
import tech.simter.auth.dto.AuthenticatedData

import tech.simter.exception.UnauthenticatedException

/**
 * The Authentication service.
 *
 * @author RJ
 */
interface AuthenticationService {
  /**
   * Login and get the authenticated data.
   *
   * @param[appId] the id of the app do the login.
   * @param[username] the login username
   * @param[username] the login password
   *
   * @return if login success, return [Mono] with the authenticated data.
   * Otherwise return [Mono.error] with [UnauthenticatedException].
   */
  fun login(appId: String, username: String, password: String): Mono<AuthenticatedData>
}