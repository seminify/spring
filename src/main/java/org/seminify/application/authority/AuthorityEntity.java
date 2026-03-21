package org.seminify.application.authority;

import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table(name = "authority")
@Data
@Accessors(chain = true)
public class AuthorityEntity {
    @GeneratedValue(strategy = IDENTITY)
    @Id
    private Long id;
    @Column(nullable = false, unique = true)
    private String authority;
}
