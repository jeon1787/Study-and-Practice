package com.jeon1787.OAuth20.domain.loginDAO;

import com.jeon1787.OAuth20.domain.LoginDTO;

public interface LoginDAO {

  /**
   * sns 회원가입
   * @param loginDTO
   * @return
   */
  void create(LoginDTO loginDTO);
}
