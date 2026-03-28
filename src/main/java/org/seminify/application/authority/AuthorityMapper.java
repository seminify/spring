package org.seminify.application.authority;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthorityMapper {
  void delete(AuthorityDTO authorityDTO);
  List<AuthorityDTO> get();
  AuthorityDTO getById(AuthorityDTO authorityDTO);
  AuthorityDTO getByAuthority(AuthorityDTO authorityDTO);
  void post(AuthorityDTO authorityDTO);
  void put(AuthorityDTO authorityDTO);
}
