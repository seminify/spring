package org.seminify.application.controller.anonymous.nav;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.seminify.application.nav.NavDTO;
import org.seminify.application.nav.NavService;
import org.seminify.application.user.UserDTO;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("anonymous/nav")
@RestController
public class NavController {

  private final NavService navService;

  @GetMapping
  public List<NavDTO> get(@AuthenticationPrincipal UserDTO userDTO) {
    return navService.getByAuthorities(userDTO.getAuthorities());
  }
}
