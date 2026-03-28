package org.seminify.application.authority;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;

@Data
@Accessors(chain = true)
public class AuthorityDTO implements GrantedAuthority {

  private Long id;
  private String authority;
  private Long order;
}
