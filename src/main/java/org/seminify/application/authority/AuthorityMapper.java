package org.seminify.application.authority;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthorityMapper {
    void delete(AuthorityDTO authorityDTO);

    List<AuthorityDTO> get();

    void post(AuthorityDTO authorityDTO);

    AuthorityDTO getByAuthority(AuthorityDTO authorityDTO);
}
