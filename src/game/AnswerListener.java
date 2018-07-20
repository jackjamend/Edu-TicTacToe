/**
 * AnswerListener.java 1.0 Jul 19, 2018
 *
 * Copyright (c) 2018 Jack Amend. All Rights Reserved
 * Elon University, Elon, NC 27144
 */
package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Start each class or interface with summary description line
 *
 * @author Jack J Amend
 * @version 1.0
 *
 */
public class AnswerListener implements ActionListener {

  /*
   * (non-Javadoc)
   * 
   * @see
   * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
   */
  @Override
  public void actionPerformed(ActionEvent aE) {
    // TODO Auto-generated method stub
    Controller.answerSubmitted(aE.getActionCommand().toString());
  }

}