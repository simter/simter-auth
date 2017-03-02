package tech.simter.auth.authentication;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The authenticated data.
 *
 * @author RJ
 * @since JDK1.8
 */
public class AuthenticatedData {
  private String ts;
  private String token;

  public AuthenticatedData(String token) {
    this.token = token;
    this.ts = LocalDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
  }

  /**
   * The authenticated timestamp with {@link DateTimeFormatter#ISO_OFFSET_DATE_TIME} format,
   * such as '2011-12-03T10:15:30+01:00'.
   */
  public String getTs() {
    return ts;
  }

  /**
   * The authenticated token.
   */
  public String getToken() {
    return token;
  }
}
