package tech.simter.auth.authentication;

import tech.simter.CodeException;

/**
 * The login exception.
 *
 * @author RJ
 * @since JDK1.8
 */
public class LoginException extends CodeException {

  private final LoginErrorCode loginErrorCode;

  /**
   * @param loginErrorCode The loginErrorCode
   * @param args           The markup value for the error message template
   */
  public LoginException(LoginErrorCode loginErrorCode, String... args) {
    super(loginErrorCode.code(), args);
    this.loginErrorCode = loginErrorCode;
  }

  /**
   * Get the LoginErrorCode
   */
  public LoginErrorCode getLoginErrorCode() {
    return loginErrorCode;
  }
}