package org.seminify.application.file;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("file")
public class FileProperties {

  private String path = "file";

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }
}
