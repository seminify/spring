package org.seminify.application.controller.anonymous.user;

import lombok.RequiredArgsConstructor;
import org.seminify.application.user.UserDTO;
import org.seminify.application.user.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("anonymous/user")
@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping
  public void post(@RequestBody UserDTO userDTO) {
    userService.postUser(userDTO);
  }
}
