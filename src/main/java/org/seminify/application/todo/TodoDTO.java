package org.seminify.application.todo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.seminify.application.user.UserDTO;

@Data
@Accessors(chain = true)
public class TodoDTO {

  private Long id;
  private UserDTO user;
  private String title;
  private boolean enable;
}
