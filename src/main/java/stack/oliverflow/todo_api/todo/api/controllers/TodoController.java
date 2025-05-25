package stack.oliverflow.todo_api.todo.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stack.oliverflow.todo_api.todo.application.TodoApplicationService;
import stack.oliverflow.todo_api.todo.application.dto.TodoRequestDTO;
import stack.oliverflow.todo_api.todo.application.dto.TodoResponseDTO;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

  @Autowired
  private TodoApplicationService service;

  @GetMapping()
  public ResponseEntity<List<TodoResponseDTO>> getList() {
    return new ResponseEntity<List<TodoResponseDTO>>(service.list(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<TodoResponseDTO> findOneById(@PathVariable int id) {
    return new ResponseEntity<TodoResponseDTO>(service.findById(id), HttpStatus.OK);
  }

  @PostMapping()
  public ResponseEntity<TodoResponseDTO> create(@RequestBody TodoRequestDTO todo) {
    return new ResponseEntity<TodoResponseDTO>(service.create(todo), HttpStatus.CREATED);
  }

  @PutMapping()
  public ResponseEntity<TodoResponseDTO> update(@RequestBody TodoRequestDTO todo) {
    return null;
  }

  @DeleteMapping("/:id")
  public ResponseEntity<TodoResponseDTO> delete(@PathVariable int id) {
    return null;
  }
}
