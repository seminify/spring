package org.seminify.application.controller.admin.user.authority;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.seminify.application.user.authority.UserAuthorityDTO;
import org.seminify.application.user.authority.UserAuthorityService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("admin/user/authority")
@RestController
@RequiredArgsConstructor
public class UserAuthorityController {

  private final UserAuthorityService userAuthorityService;

  @DeleteMapping
  public void delete(@RequestBody UserAuthorityDTO userAuthorityDTO) {
    userAuthorityService.delete(userAuthorityDTO);
  }

  @GetMapping
  public List<UserAuthorityDTO> get() {
    return userAuthorityService.get();
  }

  @PostMapping
  public void post(@RequestBody UserAuthorityDTO userAuthorityDTO) {
    userAuthorityService.post(userAuthorityDTO);
  }
}
