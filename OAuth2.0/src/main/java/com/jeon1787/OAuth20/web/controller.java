package com.jeon1787.OAuth20.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping
public class controller {
  @GetMapping("/OAuth2-study")
  public String login(){
    return "login";
  }
}
