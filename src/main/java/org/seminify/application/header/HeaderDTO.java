package org.seminify.application.header;

import lombok.Data;
import lombok.experimental.Accessors;
import org.seminify.application.authority.AuthorityDTO;

@Data
@Accessors(chain = true)
public class HeaderDTO {

  private Long id;
  private String title;
  private String src;
  private Long order;
  private HeaderDTO header;
  private AuthorityDTO authority;
}
