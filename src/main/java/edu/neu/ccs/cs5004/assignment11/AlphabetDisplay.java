package edu.neu.ccs.cs5004.assignmnet11;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * Created by RachelDi on 10/04/2017.
 */

/**
 * This view displays the alphabet bar.
 */
public class AlphabetDisplay extends JPanel {

  JLabel[] arr = new JLabel[26];

  /**
   * Build a alphabet bar.
   * Initializes its properties initialized.
   */
  public AlphabetDisplay() {
    super(new GridLayout(1, 26));
    for (char i = 'a'; i <= 'z'; i++) {
      JLabel letter = new JLabel(i + "");
      letter.setFont(new Font(Font.MONOSPACED, Font.BOLD, 10));
      letter.setForeground(Color.GRAY);
      letter.setPreferredSize(new Dimension(20, 20));
      add(letter);
      arr[i - 'a'] = letter;
    }
    setVisible(true);
  }

  /**
   * Change the color of the character's color.
   *
   * @param guess The character that the user typed.
   */
  protected void changeColor(char guess) {
    arr[guess - 'a'].setForeground(Color.BLUE);
   // repaint();
  }

  /**
   * Paint the component.
   *
   * @param graphics the Graphics context in which to paint
   */
 // @Override
 // protected void paintComponent(Graphics graphics) {
    //super.paintComponent(graphics);
 // }
}
