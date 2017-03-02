package tech.simter.auth;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tech.simter.auth.authentication.AuthenticationService;
import tech.simter.auth.authentication.EncryptType;
import tech.simter.auth.authentication.LoginErrorCode;
import tech.simter.auth.authentication.LoginException;

import static org.mockito.Mockito.*;

public class AuthenticationServiceTest {
  private AuthenticationService service;

  @Before
  public void init() {
    // create mock
    service = mock(AuthenticationService.class);
  }

  @Test
  public void ok() {
    // mock
    doNothing().when(service).verify("simter", "rightPassword", EncryptType.MD5);

    // invoke then verify
    service.verify("simter", "rightPassword", EncryptType.MD5);
    verify(service, times(1)).verify("simter", "rightPassword", EncryptType.MD5);
  }

  @Test
  public void passwordError() {
    // mock
    doThrow(new LoginException(LoginErrorCode.PasswordError)).when(service)
      .verify("simter", "wrongPassword", EncryptType.MD5);

    // invoke then verify
    LoginException loginException = null;
    try {
      service.verify("simter", "wrongPassword", EncryptType.MD5);
    } catch (LoginException e) {
      loginException = e;
    } finally {
      Assert.assertNotNull(loginException);
      Assert.assertEquals(LoginErrorCode.PasswordError, loginException.getLoginErrorCode());
    }
  }

  @Test
  public void accountNotExists() {
    // mock
    doThrow(new LoginException(LoginErrorCode.AccountNotExists)).when(service)
      .verify("notExistsAccountName", "...", EncryptType.MD5);

    // invoke then verify
    LoginException loginException = null;
    try {
      service.verify("notExistsAccountName", "...", EncryptType.MD5);
    } catch (LoginException e) {
      loginException = e;
    } finally {
      Assert.assertNotNull(loginException);
      Assert.assertEquals(LoginErrorCode.AccountNotExists, loginException.getLoginErrorCode());
    }
  }
}