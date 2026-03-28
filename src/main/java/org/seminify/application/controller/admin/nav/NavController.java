package org.seminify.application.controller.admin.nav;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.seminify.application.nav.NavDTO;
import org.seminify.application.nav.NavService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("admin/nav")
@RestController
@RequiredArgsConstructor
public class NavController {

  private final NavService navService;

  @DeleteMapping
  public void delete(@RequestBody NavDTO navDTO) {
    navService.delete(navDTO);
  }

  @GetMapping
  public List<NavDTO> get() {
    return navService.get();
  }

  @GetMapping("{id}")
  public NavDTO getById(NavDTO navDTO) {
    return navService.getById(navDTO);
  }

  @PostMapping
  public void post(@RequestBody NavDTO navDTO) {
    navService.post(navDTO);
  }

  @PutMapping
  public void put(@RequestBody NavDTO navDTO) {
    navService.put(navDTO);
  }
}
