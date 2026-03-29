package org.seminify.application.nav;

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

@Entity
@Table(name = "nav")
@Data
@Accessors(chain = true)
public class NavEntity {

  @GeneratedValue(strategy = IDENTITY)
  @Id
  private Long id;

  @JoinColumn(name = "nav_id")
  @ManyToOne(fetch = LAZY)
  private NavEntity navEntity;

  @JoinColumn(name = "authority_id")
  @ManyToOne(fetch = LAZY)
  private AuthorityEntity authorityEntity;

  private String title;
  private String src;
  private Long order;
}
