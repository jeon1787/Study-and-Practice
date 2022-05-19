package com.jeon1787.OAuth20.domain.loginDAO;

import com.jeon1787.OAuth20.domain.LoginDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class LoginDAOImpl implements LoginDAO{

  //@RequiredArgsConstructor 으로 인스턴스 주입
  private final JdbcTemplate jdbcTemplate;

  /**
   * sns 회원가입
   * @param loginDTO
   * @return
   */
  @Override
  public void create(LoginDTO loginDTO) {
    StringBuffer sql = new StringBuffer();
    sql.append(" INSERT INTO (id, username, email, nickname, sns_name, create_date, modify_date) ");
    sql.append(" VALUES ( ?, ?, ?, ?, ?, ?, ?) ");
//    sql.append(" VALUES ( ?, ?, ?, ?, ?, 'TO_TIMESTAMP('2022-02-10 08:10:00', 'YYYY-MM-DD HH24:MI:SS'), 'TO_TIMESTAMP('2022-02-10 08:10:00', 'YYYY-MM-DD HH24:MI:SS')) ");

//    LocalDateTime create_date = LocalDateTime.now();

//    int result2 = jdbcTemplate.update()
    int result = jdbcTemplate.update(sql.toString(), loginDTO.getId(), loginDTO.getUsername(), loginDTO.getEmail(), loginDTO.getNickname(), loginDTO.getSns_name(), null, null);

    log.info(result + "행 insert 성공");
  }
}
