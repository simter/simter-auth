package tech.simter.auth.authentication;

import tech.simter.jwt.JWT;

/**
 * The JWT Token
 *
 * @author RJ
 * @since JDK1.8
 */
public class JWTToken implements Token{
  @Override
  public JWT get() {
    return null;
  }

  public JWTToken() {
  }
}
