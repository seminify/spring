package org.seminify.application.controller.admin.user;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.seminify.application.user.UserDTO;
import org.seminify.application.user.UserService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("admin/user")
@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @DeleteMapping
  public void delete(@RequestBody UserDTO userDTO) {
    userService.delete(userDTO);
  }

  @GetMapping
  public List<UserDTO> get() {
    return userService.get();
  }

  @PostMapping
  public void post(@RequestBody UserDTO userDTO) {
    userService.postAdmin(userDTO);
  }
}
