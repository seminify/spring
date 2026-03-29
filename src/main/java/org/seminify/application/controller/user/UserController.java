package org.seminify.application.controller.user;

import lombok.RequiredArgsConstructor;
import org.seminify.application.user.UserDTO;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("user")
@RestController
public class UserController {

  @GetMapping
  public UserDTO get(@AuthenticationPrincipal UserDTO userDTO) {
    return userDTO;
  }
}
