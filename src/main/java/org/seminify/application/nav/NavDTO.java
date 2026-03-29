package org.seminify.application.nav;

import lombok.Data;
import lombok.experimental.Accessors;
import org.seminify.application.authority.AuthorityDTO;

@Data
@Accessors(chain = true)
public class NavDTO {

  private Long id;
  private NavDTO nav;
  private AuthorityDTO authority;
  private String title;
  private String src;
  private Long order;
}
