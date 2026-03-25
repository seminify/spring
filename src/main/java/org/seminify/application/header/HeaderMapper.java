package org.seminify.application.header;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.seminify.application.authority.AuthorityDTO;

@Mapper
public interface HeaderMapper {
    void delete(HeaderDTO headerDTO);

    List<HeaderDTO> get();

    List<HeaderDTO> getByAuthorities(List<AuthorityDTO> authorities);

    void post(HeaderDTO headerDTO);
}
