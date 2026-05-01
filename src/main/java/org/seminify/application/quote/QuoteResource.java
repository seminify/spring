package org.seminify.application.quote;

public class QuoteResource {

  private String type;
  private Quote value;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Quote getValue() {
    return value;
  }

  public void setValue(Quote value) {
    this.value = value;
  }

  public QuoteResource(String type, Quote value) {
    this.type = type;
    this.value = value;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((type == null) ? 0 : type.hashCode());
    result = prime * result + ((value == null) ? 0 : value.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    QuoteResource other = (QuoteResource) obj;
    if (type == null) {
      if (other.type != null) return false;
    } else if (!type.equals(other.type)) return false;
    if (value == null) {
      if (other.value != null) return false;
    } else if (!value.equals(other.value)) return false;
    return true;
  }

  @Override
  public String toString() {
    return "QuoteResource [type=" + type + ", value=" + value + "]";
  }
}
