package org.seminify.application.nav;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.seminify.application.authority.AuthorityDTO;

@Mapper
public interface NavMapper {
  void delete(NavDTO navDTO);
  List<NavDTO> get();
  NavDTO getById(NavDTO navDTO);
  List<NavDTO> getByAuthorities(List<AuthorityDTO> authorities);
  void post(NavDTO navDTO);
  void put(NavDTO navDTO);
}
