package edu.neu.ccs.cs5004.assignmnet11;

import java.awt.Graphics;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Created by RachelDi on 10/04/2017.
 */

/**
 * This view displays the game status.
 */
public class GameStatusDisplay extends JPanel implements Observer {
  private JLabel label;

  /**
   * Construct a game status display with the hang man model.
   * Initializes its properties.
   *
   * @param model the hang man model that passed in
   */
  public GameStatusDisplay(HangmanModel model) {
    super();
    label = new JLabel(model.showCurrentProcess().toString());
    model.addObserver(this);
    add(label);
  }

  /**
   * Paint the component.
   *
   * @param graphics the Graphics context in which to paint
   */
 // @Override
  //protected void paintComponent(Graphics graphics) {
   // super.paintComponent(graphics);
 // }

  /**
   * Update the game status whenever the observable object
   * changes. The label will show new message.
   *
   * @param obs the observable object.
   * @param arg an argument passed to the notifyObservers method. (not used here)
   */
  @Override
  public void update(Observable obs, Object arg) {
    if (!(obs instanceof HangmanModel)) {
      throw new WrongObservableException(obs + "is not the correct observable object.");
    }
    HangmanModel model = (HangmanModel) obs;
    label.setText(model.showCurrentProcess().toString());
  //  repaint();
  }
}
