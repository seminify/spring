package org.seminify.application.nav;

import org.seminify.application.authority.AuthorityDTO;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class NavDTO {

  private Long id;
  private String title;
  private String src;
  private Long order;
  private NavDTO nav;
  private AuthorityDTO authority;
}
