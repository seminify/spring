package org.seminify.application.user.authority;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserAuthorityMapper {
  void delete(UserAuthorityDTO userAuthorityDTO);

  List<UserAuthorityDTO> get();

  void post(UserAuthorityDTO userAuthorityDTO);
}
