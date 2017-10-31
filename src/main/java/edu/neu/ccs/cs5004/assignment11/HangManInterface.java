package edu.neu.ccs.cs5004.assignmnet11;

/**
 * Created by RachelDi on 11/04/2017.
 */

/**
 * The interface of hang man game.
 */
public interface HangManInterface {

  /**
   * Creates a hang man controller.
   *
   * @return a hang man controller.
   */
  static HangmanController createHangMan() {
    return new HangmanController();
  }

  /**
   * Initialize the hang man controller.
   *
   * @param model the hang man model that passed in.
   */
  void initial(HangmanModel model);
}
