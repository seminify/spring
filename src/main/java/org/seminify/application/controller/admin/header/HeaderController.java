package org.seminify.application.controller.admin.header;

import java.util.List;

import org.seminify.application.header.HeaderDTO;
import org.seminify.application.header.HeaderService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequestMapping("admin/header")
@RestController
@RequiredArgsConstructor
public class HeaderController {
    private final HeaderService headerService;

    @DeleteMapping
    public void delete(@RequestBody HeaderDTO headerDTO) {
        headerService.delete(headerDTO);
    }

    @GetMapping
    public List<HeaderDTO> get() {
        return headerService.get();
    }

    @PostMapping
    public void post(@RequestBody HeaderDTO headerDTO) {
        headerService.post(headerDTO);
    }
}
