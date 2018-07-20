/**
 * AnswerFocusListener.java 1.0 Jul 19, 2018
 *
 * Copyright (c) 2018 Jack Amend. All Rights Reserved
 * Elon University, Elon, NC 27144
 */
package game;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Start each class or interface with summary description line
 *
 * @author Jack J Amend
 * @version 1.0
 *
 */
public class AnswerFocusListener implements FocusListener {

  /*
   * (non-Javadoc)
   * 
   * @see java.awt.event.FocusListener#focusGained(java.awt.event.FocusEvent)
   */
  @Override
  public void focusGained(FocusEvent aE) {
    Controller.textBoxClicked();

  }

  /*
   * (non-Javadoc)
   * 
   * @see java.awt.event.FocusListener#focusLost(java.awt.event.FocusEvent)
   */
  @Override
  public void focusLost(FocusEvent aE) {
    // TODO Auto-generated method stub

  }

}
