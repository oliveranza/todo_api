package stack.oliverflow.todo_api.todo.application;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stack.oliverflow.todo_api.todo.application.dto.TodoRequestDTO;
import stack.oliverflow.todo_api.todo.application.dto.TodoResponseDTO;
import stack.oliverflow.todo_api.todo.application.mappers.TodoMapper;
import stack.oliverflow.todo_api.todo.domain.model.Todo;
import stack.oliverflow.todo_api.todo.domain.service.TodoService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TodoApplicationService {

  @Autowired
  private TodoService todoService;

  @Autowired
  private TodoMapper mapper;

  private final Logger logger = LoggerFactory.getLogger(TodoApplicationService.class);

  public List<TodoResponseDTO> list() {
    return todoService.list().stream().map(ele -> mapper.mapToResponseDTO(ele)).toList();
  }

  public TodoResponseDTO findById(int id) throws NoSuchElementException {
    try {
      Todo todo = todoService.findById(id);
      return mapper.mapToResponseDTO(todo);
    } catch (NoSuchElementException e) {
      throw e;
    }
  }

  public TodoResponseDTO create(TodoRequestDTO todoRequestDTO) {
    System.out.println(todoRequestDTO);

    Todo todo = mapper.mapToEntity(todoRequestDTO);
    System.out.println(todo.getId());
    logger.info(todo.getTitle());
    todo = todoService.create(todo);
    return mapper.mapToResponseDTO(todo);
  }

  public void update(Todo todo) throws NoSuchElementException {
    try {
      findById(todo.getId());
      todoService.update(todo);
    } catch (NoSuchElementException e) {
      throw e;
    }
  }

  public void delete(int id) throws NoSuchElementException {
    try {
      findById(id);
      todoService.delete(id);
    } catch (NoSuchElementException e) {
      throw e;
    }

  }
}
