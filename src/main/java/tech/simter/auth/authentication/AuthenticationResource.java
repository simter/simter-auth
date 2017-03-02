package tech.simter.auth.authentication;

import tech.simter.CodeException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * The HTTP Interface of Authentication
 *
 * @author RJ
 * @since JDK1.8
 */
@Path("/login")
public interface AuthenticationResource {
  /**
   * Login with the specific post data
   *
   * @param loginData The post data to verify. It's structure describes below:
   *             <ul>
   *             <li>[0] : {int} The Login-Type, see constants of LOGIN_TYPE_XXX</li>
   *             <li>[1] : {String} The Account Name</li>
   *             <li>[2] : {String} The Password</li>
   *             <li>[3] : {String} The Encrypt-Type of the password. If ignore this argument, the default value is "MD5"</li>
   *             </ul>
   * @return The authenticated data
   * @throws CodeException If authenticated failed
   */
  @POST
  @Path("/")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  AuthenticatedData verify(LoginData loginData);
}