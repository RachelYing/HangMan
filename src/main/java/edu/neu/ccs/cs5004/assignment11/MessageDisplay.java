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
 * This view displays the message.
 */
public class MessageDisplay extends JPanel implements Observer {
  private JLabel label;

  /**
   * Constructs a message display.
   * Initializes its properties.
   */
  public MessageDisplay(HangmanModel model) {
    super();
    int life = model.getLife();
    int numMark = model.getNumMark();
    label = new JLabel(new MessageContent().message(life, numMark));
    model.addObserver(this);
    add(label);
  }

  /**
   * Paint the component.
   *
   * @param graphics the Graphics context in which to paint
   */
//  @Override
//  protected void paintComponent(Graphics graphics) {
//    super.paintComponent(graphics);
//  }

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
    int life = model.getLife();
    int numMark = model.getNumMark();
    label.setText(new MessageContent().message(life, numMark));
   // repaint();
  }
}
