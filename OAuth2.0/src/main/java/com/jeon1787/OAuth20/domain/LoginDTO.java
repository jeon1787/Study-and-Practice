package com.jeon1787.OAuth20.domain;

import lombok.Data;

@Data
public class LoginDTO {
  String id;
  String username;
  String email;
  String nickname;
  String sns_name;
}
