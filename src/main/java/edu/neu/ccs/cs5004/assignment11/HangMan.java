package edu.neu.ccs.cs5004.assignmnet11;

import java.awt.Graphics;
import java.awt.Image;

import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Created by RachelDi on 08/04/2017.
 */

/**
 * This view displays the hang man picture.
 */
public class HangMan extends JLabel implements Observer {
  private static final String PATH = "images/";
  private static final String IMAGE_NAME = "Hangman";
  private ImageIcon icon;
  private static final String SUFFIX = ".png";

  /**
   * Constructs a hang man with a hang man model.
   * Initializes its properties initialized.
   *
   * @param model the hang man model that passed in
   */
  public HangMan(HangmanModel model) {
    this(model.getLife());
    model.addObserver(this);
    setVisible(true);
  }

  /**
   * Constructs a hang man with the identifier of current image.
   *
   * @param currentMan the identifier of current image.
   */
  public HangMan(int currentMan) {
    super(new ImageIcon(PATH + IMAGE_NAME + currentMan + SUFFIX));
    icon = getMan(currentMan);
  }

  /**
   * Get the image of the identifier of current image.
   *
   * @param currentMan the identifier of current image.
   * @return the image of the identifier of current image.
   */
  private ImageIcon getMan(int currentMan) {
    if (currentMan >= 0) {
      String completeName = PATH + IMAGE_NAME + currentMan + SUFFIX;
      icon = new ImageIcon(completeName);
    }
    return icon;
  }

  /**
   * Paint the component.
   *
   * @param graphics the Graphics context in which to paint
   */
  @Override
  protected void paintComponent(Graphics graphics) {
    super.paintComponent(graphics);
    Image image = icon.getImage();
    graphics.drawImage(image, 0, 0, null);
    repaint();
  }

  /**
   * Update the game status whenever the observable object
   * changes. The next image will be showed.
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
    icon=getMan(model.getLife());
    System.out.println(model.getLife());
    repaint();
  }
}
