package org.seminify.application.user.authority;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;
import org.seminify.application.authority.AuthorityEntity;
import org.seminify.application.user.UserEntity;

@Entity
@Table(name = "user_authority")
@Data
@Accessors(chain = true)
public class UserAuthorityEntity {

  @GeneratedValue(strategy = IDENTITY)
  @Id
  private Long id;

  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private UserEntity userEntity;

  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "authority_id", nullable = false)
  private AuthorityEntity authorityEntity;
}
