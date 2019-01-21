package tech.simter.auth.authentication;

/**
 * The Token interface
 *
 * @author RJ
 * @since JDK1.8
 */
public interface Token {
  <T> T get();
}
