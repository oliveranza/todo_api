package stack.oliverflow.todo_api.todo.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_item")
public class Todo {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(length = 100)
  private String title;

  @Column(length = 500)
  private String content;

  private boolean done;

  @DateTimeFormat(pattern = "dd/MM/YYYY HH:mm:ss")
  private LocalDateTime createdAt;

  @DateTimeFormat(pattern = "dd/MM/YYYY HH:mm:ss")
  private LocalDateTime updatedAt;

  @PrePersist
  public void prePersist() {
    this.createdAt = LocalDateTime.now();
    this.updatedAt = LocalDateTime.now();

  }

  @PreUpdate
  public void preUpdate() {
    this.updatedAt = LocalDateTime.now();
  }

}
