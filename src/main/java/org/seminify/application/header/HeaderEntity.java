package org.seminify.application.header;

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
@Table(name = "header")
@Data
@Accessors(chain = true)
public class HeaderEntity {

  @GeneratedValue(strategy = IDENTITY)
  @Id
  private Long id;

  private String title;
  private String src;

  @Column(nullable = false)
  private Long order;

  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "header_id")
  private HeaderEntity headerEntity;

  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "authority_id")
  private AuthorityEntity authorityEntity;
}
