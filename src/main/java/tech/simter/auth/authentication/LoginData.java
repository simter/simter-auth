package tech.simter.auth.authentication;

import javax.json.Json;
import javax.json.JsonArray;
import java.io.StringReader;

/**
 * The login data.
 *
 * @author RJ
 * @since JDK1.8
 */
public class LoginData {
  /**
   * Login with account and password
   */
  public int LOGIN_TYPE_CLASSICAL = 1;

  /**
   * Login with account and password
   */
  public String ENCRYPT_TYPE_MD5 = "MD5";

  private LoginType loginType;
  private String account;
  private String password;
  private EncryptType encryptType;

  public LoginType getLoginType() {
    return loginType;
  }

  public String getAccount() {
    return account;
  }

  public String getPassword() {
    return password;
  }

  /**
   * The password encrypt type.
   */
  public EncryptType getEncryptType() {
    return encryptType;
  }

  /**
   * The method for auto convert body text to POJO
   *
   * @param body The request post data. It's structure describes below:
   *             <ul>
   *             <li>[0] : {int} The Login-Type, see constants of LOGIN_TYPE_XXX</li>
   *             <li>[1] : {String} The Account Name</li>
   *             <li>[2] : {String} The Password</li>
   *             <li>[3] : {String} The Encrypt-Type of the password. If ignore this argument, the default value is "MD5"</li>
   *             </ul>
   * @return Specific POJO instance
   */
  public static LoginData valueOf(String body) {
    // body structure: [_LOGIN\_TYPE_, "_ACCOUNT_", "_PASSWORD_", "_ENCRYPT\_TYPE_"]
    JsonArray jsonArray = Json.createReader(new StringReader(body)).readArray();
    LoginData data = new LoginData();
    data.loginType = LoginType.valueOf(jsonArray.getInt(0));
    data.account = jsonArray.getString(1);
    data.password = jsonArray.getString(2);

    // encryptType is optional
    data.encryptType = jsonArray.size() > 3 ? EncryptType.valueOf(jsonArray.getString(3)) : EncryptType.MD5;
    return data;
  }
}