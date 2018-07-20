/**
 * ButtonListener.java 1.0 Apr 27, 2018
 *
 * Copyright (c) 2018 Jack Amend. All Rights Reserved
 * Elon University, Elon, NC 27144
 */
package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * Button Listener class that inherits from action listener. Passes along which button was clicked
 * to the controller.
 *
 * @author jackamend
 * @version 1.0
 *
 */
public class ButtonListener implements ActionListener {

  @Override
  public void actionPerformed(ActionEvent aE) {
    // System.out.println("Is model set" + model);
    JButton button = (JButton) aE.getSource();
    int buttonClicked = Integer.parseInt(button.getName());
    Controller.buttonClicked(buttonClicked);
  }

}
