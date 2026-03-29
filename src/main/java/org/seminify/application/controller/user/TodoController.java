package org.seminify.application.controller.user;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.seminify.application.todo.TodoDTO;
import org.seminify.application.todo.TodoService;
import org.seminify.application.user.UserDTO;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("user/todo")
@RestController
public class TodoController {

  private final TodoService todoService;

  @DeleteMapping
  public void delete(
    @AuthenticationPrincipal UserDTO userDTO,
    @RequestBody TodoDTO todoDTO
  ) {
    todoService.delete(userDTO, todoDTO);
  }

  @GetMapping
  public List<TodoDTO> getByUser(@AuthenticationPrincipal UserDTO userDTO) {
    return todoService.getByUser(userDTO);
  }

  @PostMapping
  public void post(
    @AuthenticationPrincipal UserDTO userDTO,
    @RequestBody TodoDTO todoDTO
  ) {
    todoService.post(userDTO, todoDTO);
  }

  @PutMapping
  public void put(
    @AuthenticationPrincipal UserDTO userDTO,
    @RequestBody TodoDTO todoDTO
  ) {
    todoService.put(userDTO, todoDTO);
  }
}
