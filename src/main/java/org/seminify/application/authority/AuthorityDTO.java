package org.seminify.application.authority;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class AuthorityDTO implements GrantedAuthority {
    private Long id;
    private String authority;
    private Long order;
}
