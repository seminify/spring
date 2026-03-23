package org.seminify.application.header;

import org.seminify.application.authority.AuthorityDTO;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class HeaderDTO {
    private Long id;
    private String header;
    private String src;
    private AuthorityDTO authority;
    private Long order;
}
