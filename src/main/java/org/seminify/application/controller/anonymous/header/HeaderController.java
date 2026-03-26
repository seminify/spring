package org.seminify.application.controller.anonymous.header;

import java.util.List;

import org.seminify.application.header.HeaderDTO;
import org.seminify.application.header.HeaderService;
import org.seminify.application.user.UserDTO;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequestMapping("anonymous/header")
@RestController
@RequiredArgsConstructor
public class HeaderController {
    private final HeaderService headerService;

    @GetMapping
    public List<HeaderDTO> get(@AuthenticationPrincipal UserDTO userDTO) {
        return headerService.getByAuthorities(userDTO.getAuthorities());
    }
}
