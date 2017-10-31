package edu.neu.ccs.cs5004.assignmnet11;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Created by RachelDi on 08/04/2017.
 */

/**
 * The controller of the hang man game.
 */
public class HangmanController implements HangManInterface,ActionListener, KeyListener {
  private JFrame frame;
  private HangmanModel model;
  private AlphabetDisplay choiceBar;
  private HangMan image;
  private GameStatusDisplay status;
  private MessageDisplay message;
  private JPanel panel;

  /**
   * Constructs a hang man controller.
   * Initializes its properties initialized.
   */
  public HangmanController() {
    model = new HangmanModel();
    frame = new JFrame();
    frame.setForeground(Color.WHITE);
    frame.setLayout(new FlowLayout());
    frame.setContentPane(Box.createVerticalBox());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Hangman");
    initial(model);
    frame.pack();
    frame.setVisible(true);
  }

  /**
   * Initialize the hang man controller.
   *
   * @param model the hang man model that passed in.
   */
  @Override
  public void initial(HangmanModel model) {
    image = new HangMan(model);
    frame.add(image);
    status = new GameStatusDisplay(model);
    frame.add(status);
    message = new MessageDisplay(model);
    frame.add(message);
    choiceBar = new AlphabetDisplay();
    frame.add(choiceBar);
    JButton button = new JButton("New");
    button.setBackground(Color.BLUE);
    button.addActionListener(this);
    button.setAlignmentX(Component.CENTER_ALIGNMENT);
    button.setAlignmentY(Component.CENTER_ALIGNMENT);
    button.addKeyListener(this);
    panel = new JPanel();
    panel.add(button);
    frame.add(panel);
  }

  /**
   * New game starts when an action occurs.
   *
   * @param evt an action event that passed in.
   */
  @Override
  public void actionPerformed(ActionEvent evt) {
    model.newGame();
  }

  /**
   * The color of the typed key(character) will changed.
   * The hang man model will reply to the key event.
   *
   * @param evt the key event that passed in.
   */
  @Override
  public void keyTyped(KeyEvent evt) {
    char letter = evt.getKeyChar();
    if (!(('a' <= letter && 'z' >= letter) || ('A' <= letter && 'Z' >= letter))) {
      throw new InvalidGuessException("The letter is not in alphabet.");
    }
    choiceBar.changeColor(letter);
    model.doOneGuess(letter);
  }

  /**
   * Invoked when a key is pressed.
   *
   * @param evt the key event that passed in.
   */
  @Override
  public void keyPressed(KeyEvent evt) {
  }

  /**
   * Invoked when a key is released.
   *
   * @param evt the key event that passed in.
   */
  @Override
  public void keyReleased(KeyEvent evt) {
  }
}
