package org.seminify.application.controller.admin.authority;

import java.util.List;

import org.seminify.application.authority.AuthorityDTO;
import org.seminify.application.authority.AuthorityService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequestMapping("admin/authority")
@RestController
@RequiredArgsConstructor
public class AuthorityController {
    private final AuthorityService authorityService;

    @DeleteMapping
    public void delete(@RequestBody AuthorityDTO authorityDTO) {
        authorityService.delete(authorityDTO);
    }

    @GetMapping
    public List<AuthorityDTO> get() {
        return authorityService.get();
    }

    @PostMapping
    public void post(@RequestBody AuthorityDTO authorityDTO) {
        authorityService.post(authorityDTO);
    }
}
