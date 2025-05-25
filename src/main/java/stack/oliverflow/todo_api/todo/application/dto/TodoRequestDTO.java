package stack.oliverflow.todo_api.todo.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoRequestDTO {

  private String title;
  private String content;
  private boolean done;

}
