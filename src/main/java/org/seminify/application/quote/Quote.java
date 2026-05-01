package org.seminify.application.quote;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Quote {

  @GeneratedValue
  @Id
  private Long id;

  private String quote;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getQuote() {
    return quote;
  }

  public void setQuote(String quote) {
    this.quote = quote;
  }

  public Quote() {}

  public Quote(String quote) {
    this.quote = quote;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((quote == null) ? 0 : quote.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Quote other = (Quote) obj;
    if (id == null) {
      if (other.id != null) return false;
    } else if (!id.equals(other.id)) return false;
    if (quote == null) {
      if (other.quote != null) return false;
    } else if (!quote.equals(other.quote)) return false;
    return true;
  }

  @Override
  public String toString() {
    return "Quote [id=" + id + ", quote=" + quote + "]";
  }
}
