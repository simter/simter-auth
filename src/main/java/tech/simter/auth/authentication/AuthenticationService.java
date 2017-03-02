package tech.simter.auth.authentication;

/**
 * The authentication service
 *
 * @author RJ
 * @since JDK1.8
 */
public interface AuthenticationService {
  /**
   * Check whether the account is available and the password is matching
   * <p>The password can be raw, hash or any algorithm decode, see {@link EncryptType},.base on the implements.</p>
   *
   * @param account     The user account name
   * @param password    The account's password
   * @param encryptType The password's encrypt type
   * @throws LoginException if authenticated failed
   */
  void verify(String account, String password, EncryptType encryptType) throws LoginException;
}