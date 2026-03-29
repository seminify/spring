package org.seminify.application.user;

import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;
import org.seminify.application.authority.AuthorityDTO;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@Accessors(chain = true)
public class UserDTO implements UserDetails {

  private Long id;
  private List<AuthorityDTO> authorities;
  private String username;
  private String password;
}
