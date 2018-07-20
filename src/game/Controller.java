/**
 * Controller.java 1.0 Apr 27, 2018
 *
 * Copyright (c) 2018 Jack Amend. All Rights Reserved
 * Elon University, Elon, NC 27144
 */
package game;

/**
 * Controller class for the tic tac toe game. Responsible for transferring
 * information from the model to the gui.
 *
 * @author Jack J Amend
 * @version 1.0
 *
 */
public class Controller {

  private static TicTacToeLayout gui;
  private static Model model;

  /**
   * 
   * Creates an instance of the controller.
   *
   */
  public Controller() {
    model = new Model();
    gui = new TicTacToeLayout();
    gui.setVisible(true);

  }

  /**
   * 
   * Handles the logic for when a button is pressed on the board.
   *
   * @param button
   */
  public static void buttonClicked(int button) {
    String letter = model.letterPlayed(button);
    gui.updateView(button, letter);
    if (model.gameOver()) {
      if (model.getWinner() == 0) {
        letter = "None";
      }
      gui.gameOver(letter);
      int newGame = gui.newGamePopUp();
      if (newGame == 0) {
        newGame();
      } else {
        System.exit(0);
      }
    }
  }

  private static void newGame() {
    Controller.model = new Model();
    gui.newGame();
  }

}
