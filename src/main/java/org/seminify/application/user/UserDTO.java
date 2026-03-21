package org.seminify.application.user;

import java.util.List;

import org.seminify.application.authority.AuthorityDTO;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserDTO implements UserDetails {
    private Long id;
    private String username;
    private String password;
    private List<AuthorityDTO> authorities;
}
