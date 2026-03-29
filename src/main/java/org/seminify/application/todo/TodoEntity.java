package org.seminify.application.todo;

import static jakarta.persistence.FetchType.LAZY;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;
import org.seminify.application.user.UserEntity;

@Entity
@Table(name = "todo")
@Data
@Accessors(chain = true)
public class TodoEntity {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Long id;

  @JoinColumn(name = "user_id")
  @ManyToOne(fetch = LAZY)
  private UserEntity userEntity;

  private String title;
  private boolean enable;
}
