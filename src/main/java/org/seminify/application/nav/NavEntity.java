package org.seminify.application.nav;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.Column;
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

  private String title;
  private String src;

  @Column(nullable = false)
  private Long order;

  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "nav_id")
  private NavEntity navEntity;

  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "authority_id")
  private AuthorityEntity authorityEntity;
}
