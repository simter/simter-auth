package tech.simter.auth.authentication;

/**
 * The login type of authentication.
 *
 * @author RJ
 * @since JDK1.8
 */
public enum LoginType {
  AccountPassword,
  Scan;

  public static LoginType valueOf(int index) {
    for (LoginType t : LoginType.values()) {
      if (t.ordinal() == index) return t;
    }
    throw new IllegalArgumentException("un support LoginType index=" + index);
  }
}