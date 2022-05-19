package com.jeon1787.OAuth20.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping
public class LoginController {
  @GetMapping("/OAuth2-study")
  public String beforeLogin(){
    return "beforeLogin";
  }

  @GetMapping("/OAuth2-study/callback")
  public String afterLogin(){
    return "afterLogin";
  }
}
