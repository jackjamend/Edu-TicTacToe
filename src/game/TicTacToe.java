/**
 * tictactoe.java 1.0 Dec 1, 2017
 *
 * Copyright (c) 2017 Jack Amend. All Rights Reserved
 * Elon University, Elon, NC 27144
 */
package game;

import java.io.File;

/**
 * Driver of Tic Tac Toe game.
 *
 * @author Jack J Amend
 * @version 1.0
 *
 */
public class TicTacToe {

  /**
   * Creates a controller and calls play game.
   *
   * @param args
   */
  @SuppressWarnings("unused")
  public static void main(String[] args) {
    File file = new File("math.txt");
    Controller controller = new Controller(file);
  }

}
