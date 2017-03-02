package tech.simter.auth.authentication;

import tech.simter.ErrorCode;

/**
 * The login error code 10xx.
 *
 * @author RJ
 * @since JDK1.8
 */
public enum LoginErrorCode implements ErrorCode {
  /**
   * Password not matching.
   */
  PasswordError(1001),

  /**
   * Account not exists.
   */
  AccountNotExists(1002),

  /**
   * Account exists but is disabled.
   */
  AccountDisabled(1003),

  /**
   * Account is auditing, not yet pass now.
   */
  AccountAuditing(1004);

  private final int code;

  LoginErrorCode(int code) {
    this.code = code;
  }

  /**
   * Get the error code number.
   */
  public int code() {
    return code;
  }

  /**
   * Get instance by error code number.
   *
   * @param code The error code number
   */
  public static LoginErrorCode valueOf(int code) {
    for (LoginErrorCode t : LoginErrorCode.values()) {
      if (t.code() == code) return t;
    }
    throw new IllegalArgumentException("un support LoginErrorCode code=" + code);
  }
}