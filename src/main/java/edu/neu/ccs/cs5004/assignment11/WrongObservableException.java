package edu.neu.ccs.cs5004.assignmnet11;

/**
 * Created by RachelDi on 11/04/2017.
 */

/**
 * The exception throws when the type of the notifying observable object is wrong.
 */
public class WrongObservableException extends RuntimeException {
  /**
   * Constructs a wrong observable exception with a message.
   *
   * @param message the error message
   */
  public WrongObservableException(String message) {
    super(message);
  }
}
