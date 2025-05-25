package stack.oliverflow.todo_api.todo.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stack.oliverflow.todo_api.todo.domain.model.Todo;

@Repository
public interface TodoRespository extends JpaRepository<Todo, Integer> {}
