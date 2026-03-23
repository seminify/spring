package org.seminify.application.header;

import java.util.List;

import org.seminify.application.authority.AuthorityDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequestMapping("user/header")
@RestController
@RequiredArgsConstructor
public class HeaderController {
    private final HeaderService headerService;

    @GetMapping
    public List<HeaderDTO> get() {
        return headerService.getByAuthority(new AuthorityDTO().setAuthority("ROLE_USER"));
    }
}
