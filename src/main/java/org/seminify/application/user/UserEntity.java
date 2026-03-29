package org.seminify.application.user;

import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table(name = "user")
@Data
@Accessors(chain = true)
public class UserEntity {

  @GeneratedValue(strategy = IDENTITY)
  @Id
  private Long id;

  private String username;
  private String password;
}
