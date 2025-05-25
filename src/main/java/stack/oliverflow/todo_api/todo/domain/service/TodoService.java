package stack.oliverflow.todo_api.todo.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stack.oliverflow.todo_api.todo.application.dto.TodoRequestDTO;
import stack.oliverflow.todo_api.todo.application.dto.TodoResponseDTO;
import stack.oliverflow.todo_api.todo.application.mappers.TodoMapper;
import stack.oliverflow.todo_api.todo.infrastructure.persistence.TodoRespository;
import stack.oliverflow.todo_api.todo.domain.model.Todo;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TodoService {

    @Autowired
    private TodoRespository repo;

    public List<Todo> list() {
        return repo.findAll().stream().toList();
    }

    public Todo findById(int id) throws NoSuchElementException {
        return repo.findById(id).orElseThrow(() -> new NoSuchElementException("Item não encontrado."));
    }

    public Todo create(Todo todo) {
        return repo.save(todo);
    }

    public void update(Todo todo)  throws NoSuchElementException {
        try {
            findById(todo.getId());
            repo.save(todo);
        } catch (NoSuchElementException e) {
            throw e;
        }
    }

    public void delete(int id) throws NoSuchElementException {
        try {
            findById(id);
            repo.deleteById(id);
        } catch (NoSuchElementException e) {
            throw e;
        }

    }
}
