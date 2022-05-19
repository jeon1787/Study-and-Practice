package com.jeon1787.OAuth20.domain.loginSVC;

import com.jeon1787.OAuth20.domain.LoginDTO;
import com.jeon1787.OAuth20.domain.loginDAO.LoginDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginSVCImpl implements LoginSVC{

  private final LoginDAO loginDAO;

  @Override
  public void create(LoginDTO loginDTO) {
    loginDAO.create(loginDTO);
  }
}
