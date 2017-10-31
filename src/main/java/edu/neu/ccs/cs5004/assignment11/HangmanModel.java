package edu.neu.ccs.cs5004.assignmnet11;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Random;

/**
 * Created by RachelDi on 08/04/2017.
 */

/**
 * The model of the hang man, which is observing by all the observers.
 * Handle the guess process, notify the observers when state changes.
 */
public class HangmanModel extends Observable {
  private static final int MAX_LIFE = 6;
  private int life;
  private int numMark;
  private List<Character> typedChars;
  private String answer;
  private Character[] showArr;
  private static final String SOURCE_FILE = "words.txt";

  /**
   * Constructs a hang man;
   * Initializes its properties initialized.
   */
  public HangmanModel() {
    initial();
  }

  /**
   * Initializes the properties of the hang man.
   */
  public void initial() {
    typedChars = new ArrayList();
    answer = pickWord();
    initialShowArray(answer);
    life = MAX_LIFE;
  }

  /**
   * Getter of the property "life".c
   *
   * @return the remaining life of the game.
   */
  protected int getLife() {
    return life;
  }

  /**
   * Getter of the property "numMark".
   *
   * @return the number of question marks left in the guess process display.
   */
  protected int getNumMark() {
    return numMark;
  }

  /**
   * Gets current process, which is a string consist of the letters that the player has tried
   * question marks for all letters that have not been correctly guessed.
   *
   * @return the current process.
   */
  protected String showCurrentProcess() {
    StringBuilder bulider = new StringBuilder("");
    for (int i = 0; i < showArr.length; i++) {
      bulider.append(showArr[i]);
    }
    return bulider.toString();
  }

  /**
   * Initialize the show process arrays and the character array representing the answer.
   *
   * @param answer the answer of the hang man game.
   */
  private void initialShowArray(String answer) {
    int len = answer.length();
    showArr = new Character[len];
    numMark = len;
    for (int i = 0; i < answer.length(); i++) {
      showArr[i] = '?';
    }
  }

  /**
   * Gets the result of current (one) guess, if the character is typed before,
   * return 1; otherwise if the character is in the answer, return 2;
   * otherwise return 3.
   *
   * @return 1 if the character is typed before; otherwise return 2 if the character is in the
   *     answer; otherwise return 3(if the character is not in the answer).
   */
  protected int currentGuess(char guess) {
    int result = 0;
    if (typedChars.contains(guess)) {
      result = 1;
    } else {
      typedChars.add(guess);
      for (int i = 0; i < answer.length(); i++) {
        if (answer.charAt(i) == guess) {
          showArr[i] = guess;
          result = 2;
          numMark--;
        }
      }
    }
    return result;
  }

  /**
   * Handle one guess. If the state changes because of the guess made,
   * notify all the observers.
   *
   * @param guess the guessed character that passed in.
   */
  protected void doOneGuess(char guess) {
    if (currentGuess(guess) == 0) {
      life--;
    }
    setChanged();
    notifyObservers();
  }

  /**
   * Generate the answer of the hang man game.
   *
   * @return the answer of the hang man game.
   */
  private String pickWord() {
    List<String> list = new ArrayList();
    Random random = new Random();
    BufferedReader reader;
    String line;
    try {
      reader = new BufferedReader(new InputStreamReader(
          new FileInputStream(SOURCE_FILE), "UTF-8"));
      while ((line = reader.readLine()) != null) {
        list.add(line);
      }
      reader.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    int ran = random.nextInt(list.size() - 1) % (list.size());
    return list.get(ran);
  }

  /**
   * Starts a new game.
   */
  protected void newGame() {
    initial();
    setChanged();
    notifyObservers();
  }
}
