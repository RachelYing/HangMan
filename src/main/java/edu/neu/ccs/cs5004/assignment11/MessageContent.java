package edu.neu.ccs.cs5004.assignmnet11;

/**
 * Created by RachelDi on 09/04/2017.
 */
public class MessageContent {

  /**
   * Generates message with the number of life left, snd the number of question marks left.
   *
   * @param life    the number of life left.
   * @param numMark the number of question marks left.
   * @return the message upon the number of life left, snd the number of question marks left.
   */
  protected String message(int life, int numMark) {
    if (life > 0 && numMark > 0) {
      if (life == 1) {
        return life + " guess left";
      } else {
        return life + " guesses left";
      }
    } else if (life >= 0 && numMark == 0) {
      if (life == 0 || life == 1) {
        return "You won with " + life + " guess left!";
      } else {
        return "You won with " + life + " guesses left!";
      }
    }
    return "You lost! (dullard)";
  }
}
