/**
 * Model.java 1.0 Apr 27, 2018
 *
 * Copyright (c) 2018 Jack J Amend. All Rights Reserved
 * Elon University, Elon, NC 27144
 */
package game;

/**
 * Model class for the tic tac toe game. All game logic is in this class.
 *
 * @author Jack J Amend
 * @version 1.0
 *
 */
public class Model {

  private int[] board;
  private int playerTurn;
  private int winner;

  /**
   * 
   * Creates an instance of the model class with an empty board and the first
   * player's turn.
   *
   */
  public Model() {
    board = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    playerTurn = 1;
  }

  /**
   * 
   * Returns the new players turn.
   *
   * @return which player's turn it is.
   */
  public int changeTurn() {
    return (playerTurn == 1 ? 2 : 1);
  }

  /**
   * 
   * Checks to see if the game is over.
   *
   * @return if the game is over
   */
  public boolean gameOver() {
    if (isBoardFull()) {
      winner = 0;
      return true;
    } else if (winAcross() || winDown() || winDag()) {
      winner = changeTurn();
      return true;
    }
    return false;
  }

  /**
   * 
   * Returns the winner of the game.
   *
   * @return which player won.
   */
  public int getWinner() {
    return winner;
  }

  /**
   * 
   * Updates board after a letter is played
   *
   * @param boardIndex - int of the index of which spot needs to be updated
   * @return letter played
   */
  public String letterPlayed(int boardIndex) {
    board[boardIndex] = playerTurn;
    String letter = (playerTurn == 1 ? "X" : "O");
    playerTurn = changeTurn();
    return letter;
  }

  /**
   * 
   * Prints the board to the console.
   *
   */
  public void printBoard() {

    for (int i = 0; i < board.length; i += 3) {
      System.out.printf("%-4s %-4s %-4s %n", board[i], board[i + 1],
                        board[i + 2]);
    }
  }

  private boolean isBoardFull() {
    for (int square : board) {
      if (square == 0) {
        return false;
      }
    }
    return true;
  }

  private boolean winAcross() {
    for (int i = 0; i < board.length; i += 3) {
      if (board[i] == board[i + 1] && board[i + 1] == board[i + 2]
          && board[i] != 0) {
        return true;
      }
    }
    return false;
  }

  private boolean winDag() {
    if ((board[0] == board[4] && board[4] == board[8] && board[0] != 0)
        || (board[2] == board[4] && board[4] == board[6] && board[2] != 0)) {
      return true;
    }
    return false;
  }

  private boolean winDown() {
    for (int i = 0; i < board.length / 3; i++) {
      if (board[i] == board[i + 3] && board[i + 3] == board[i + 6]
          && board[i] != 0) {
        return true;
      }
    }
    return false;
  }
}
