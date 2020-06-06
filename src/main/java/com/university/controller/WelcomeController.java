package com.university.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
		 
  @RequestMapping("/")
  public String redirectPage() {
    return "redirect:/welcome";
  }
  
  @RequestMapping("/welcome")
  public String showHomePage() {
    return "welcome";
  }
 
}