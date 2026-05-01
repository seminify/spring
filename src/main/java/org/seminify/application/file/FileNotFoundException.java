package org.seminify.application.file;

public class FileNotFoundException extends RuntimeException {

  public FileNotFoundException(String message) {
    super(message);
  }

  public FileNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }
}
