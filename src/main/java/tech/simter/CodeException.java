package tech.simter;

/**
 * The exception base on error code.
 *
 * @author RJ
 * @since JDK1.8
 */
public class CodeException extends RuntimeException {
  private final int code;
  private final String[] args;

  /**
   * @param code The error code
   * @param args The markup value for the error message template
   */
  public CodeException(int code, String... args) {
    super(convertToMessage(code, args));

    this.code = code;
    this.args = args;

  }

  private static String convertToMessage(int code, String[] args) {
    // TODO through code definition
    return code + "-with-" + args.length + "-arguments";
  }

  /**
   * Get the error code number
   */
  public int getCode() {
    return code;
  }

  /**
   * Get the markup values for the error message template
   */
  public String[] getArgs() {
    return args;
  }
}