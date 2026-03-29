package org.seminify.application.controller.admin.user.authority;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.seminify.application.user.authority.UserAuthorityDTO;
import org.seminify.application.user.authority.UserAuthorityService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("admin/user/authority")
@RestController
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

  @GetMapping("{id}")
  public UserAuthorityDTO getById(UserAuthorityDTO userAuthorityDTO) {
    return userAuthorityService.getById(userAuthorityDTO);
  }

  @PostMapping
  public void post(@RequestBody UserAuthorityDTO userAuthorityDTO) {
    userAuthorityService.post(userAuthorityDTO);
  }

  @PutMapping
  public void put(@RequestBody UserAuthorityDTO userAuthorityDTO) {
    userAuthorityService.put(userAuthorityDTO);
  }
}
