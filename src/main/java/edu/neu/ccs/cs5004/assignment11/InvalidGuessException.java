package edu.neu.ccs.cs5004.assignmnet11;

/**
 * Created by RachelDi on 11/04/2017.
 */

/**
 * The exception throws when the user hit a key not in the alphabet.
 */
public class InvalidGuessException extends RuntimeException {
  public InvalidGuessException(String message) {
    super(message);
  }
}
