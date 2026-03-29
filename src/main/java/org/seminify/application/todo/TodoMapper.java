package org.seminify.application.todo;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.seminify.application.user.UserDTO;

@Mapper
public interface TodoMapper {
  void delete(UserDTO userDTO, TodoDTO todoDTO);
  List<TodoDTO> getByUser(UserDTO userDTO);
  void post(UserDTO userDTO, TodoDTO todoDTO);
  void put(UserDTO userDTO, TodoDTO todoDTO);
}
