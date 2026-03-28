package org.seminify.application.user;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
  void delete(UserDTO userDTO);
  List<UserDTO> get();
  UserDTO getById(UserDTO userDTO);
  UserDTO loadUserByUsername(String username);
  void post(UserDTO userDTO);
  void put(UserDTO userDTO);
}
