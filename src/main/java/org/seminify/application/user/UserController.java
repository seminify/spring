package org.seminify.application.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequestMapping("user")
@RestController
@RequiredArgsConstructor
public class UserController {
    @GetMapping
    public ResponseEntity<?> get() {
        return ResponseEntity.ok().build();
    }
}
