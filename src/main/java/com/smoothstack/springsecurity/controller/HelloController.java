package com.smoothstack.springsecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rob Maes
 * Mar 16 2021
 */
@RestController
public class HelloController {

  @RequestMapping(method = RequestMethod.GET, path = "/hello")
  public String helloWorld() {
    return "Hello World!";
  }

  @RequestMapping(method = RequestMethod.GET, path = "/api/global")
  public String global() {
    return "Global";
  }

  @RequestMapping(method = RequestMethod.GET, path = "/api/public")
  public String authenticated() {
    return "Authenticated";
  }

  @RequestMapping(method = RequestMethod.GET, path = "/api/private")
  public String priv() {
    return "Private";
  }
}
