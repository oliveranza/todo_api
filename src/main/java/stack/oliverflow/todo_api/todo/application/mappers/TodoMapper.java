package stack.oliverflow.todo_api.todo.application.mappers;

import org.mapstruct.Mapper;
import stack.oliverflow.todo_api.todo.application.dto.TodoRequestDTO;
import stack.oliverflow.todo_api.todo.application.dto.TodoResponseDTO;
import stack.oliverflow.todo_api.todo.domain.model.Todo;

@Mapper(componentModel = "spring")

public interface TodoMapper {

  Todo mapToEntity(TodoResponseDTO dto);

  Todo mapToEntity(TodoRequestDTO dto);

  TodoResponseDTO mapToResponseDTO(Todo entity);

  TodoRequestDTO mapToRequestDTO(Todo entity);

}
