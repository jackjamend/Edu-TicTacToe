/**
 * Controller.java 1.0 Apr 27, 2018
 *
 * Copyright (c) 2018 Jack Amend. All Rights Reserved
 * Elon University, Elon, NC 27144
 */
package game;

import java.io.File;

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
  private static QNAModel qnaModel;

  /**
   * 
   * Creates an instance of the controller.
   *
   */
  public Controller(File file) {
    Controller.qnaModel = new QNAModel(file);
    String question = qnaModel.getCurrentQuestion();
    Controller.model = new Model();
    Controller.gui = new TicTacToeLayout();
    Controller.gui.setQuestion(question);
    Controller.gui.setVisible(true);

  }

  public static void answerSubmitted(String answer) {
    boolean correct = Controller.qnaModel.answerQuestion(answer);
    if (correct) {
      int[] open = Controller.model.getOpenSpots();
      gui.updateButtons(true, open);
    } else {
      String player = model.skipPlayer();
      Controller.gui.wrongAnswer(player);
      String question = qnaModel.getCurrentQuestion();
      Controller.gui.setQuestion(question);
    }
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
    gui.disableAllButtons();
    String question = qnaModel.getCurrentQuestion();
    gui.setQuestion(question);
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

  public static void textBoxClicked() {
    gui.clearAnswerBox();
  }

  private static void newGame() {
    Controller.model = new Model();
    gui.newGame();
  }

}
