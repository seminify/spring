package org.seminify.application.todo;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.seminify.application.user.UserDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class TodoService {

  private final TodoMapper todoMapper;

  public void delete(UserDTO userDTO, TodoDTO todoDTO) {
    todoMapper.delete(userDTO, todoDTO);
  }

  @Transactional(readOnly = true)
  public List<TodoDTO> getByUser(UserDTO userDTO) {
    return todoMapper.getByUser(userDTO);
  }

  public void post(UserDTO userDTO, TodoDTO todoDTO) {
    todoMapper.post(userDTO, todoDTO);
  }

  public void put(UserDTO userDTO, TodoDTO todoDTO) {
    todoMapper.put(userDTO, todoDTO);
  }
}
