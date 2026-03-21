package org.seminify.application.user.authority;

import org.seminify.application.authority.AuthorityDTO;
import org.seminify.application.user.UserDTO;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserAuthorityDTO {
    private Long id;
    private UserDTO user;
    private AuthorityDTO authority;
}
