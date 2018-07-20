/**
 * TicTacToeLayout.java 1.0 April 30, 2018
 *
 * Copyright (c) 2018 Jack Amend. All Rights Reserved
 * Elon University, Elon, NC 27144
 */
package game;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Class that contains functionality of updating the view for the user.
 *
 * @author Jack Amend
 * @version 1.0
 *
 */

@SuppressWarnings("serial")
public class TicTacToeLayout extends JFrame {

  // Variables for the JFrame
  private static final int FRAME_HEIGHT = 600;
  private static final String FRAME_TITLE = "Jack's TicTacToe Game";
  private static final int FRAME_WIDTH = 600;

  // Items that go into the view
  private JLabel answer;
  private JPanel boardLayout;
  private JButton[] buttons = new JButton[9];
  private JLabel playerLabel;
  private JLabel question;
  private JPanel questionPanel;

  /**
   * 
   * Creates an instance of the Tic Tac Toe board the user interacts with.
   *
   */
  public TicTacToeLayout() {
    // Creates JFrame with title, sets size, and exit operation.
    super(FRAME_TITLE);
    this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Creates panel for buttons
    createButtonsPanel();

    // Creates the player label with the starting player's name. This is made on
    // the
    // assumption that it is normal tictactoe rules with player X going first
    playerLabel = new JLabel("Player X turn");
    playerLabel.setHorizontalAlignment(SwingConstants.CENTER);
    this.add(playerLabel, BorderLayout.NORTH);

    // Question panel
    question = new JLabel("Question: ");
    answer = new JLabel("Answer: ");
    questionPanel = new JPanel();
    questionPanel.setLayout(new GridLayout(2, 1));
    questionPanel.add(question);
    questionPanel.add(answer);
    add(questionPanel, BorderLayout.SOUTH);
  }

  /**
   * 
   * Called when the game is over. Sets the player text to say who is the
   * winner.
   *
   * @param winner - The string instance of the player who won.
   */
  public void gameOver(String winner) {
    if (winner.equals("None")) {
      playerLabel.setText("Board full! Game Over!");
    } else {
      playerLabel.setText(winner + " is the winner!");
    }

  }

  /**
   * 
   * Resets the board for a new game.
   *
   */
  public void newGame() {
    this.remove(boardLayout);
    createButtonsPanel();
    playerLabel.setText("New Game! Player X turn");
  }

  /**
   * 
   * Creates a pop up window asking if the users want to play a new game
   *
   * @return newGame - int that is the response for a new game. If it is 0, then
   *         the answer is yes else the answer is no.
   */
  public int newGamePopUp() {
    String message = "Start a new game?";
    String title = "Title";
    int newGame = JOptionPane.showConfirmDialog(null, message, title, 0,
                                                JOptionPane.QUESTION_MESSAGE);
    return newGame;
  }

  /**
   * 
   * Sets the player label to say who's turn it is.
   *
   * @param letter - Letter enum of whose turn it is.
   */
  public void setPlayerText(String letter) {
    playerLabel.setText("Player " + letter + " turn");
  }

  /**
   * 
   * Updates the current GUI view. Changes the buttons to reflect the played
   * square and makes the button not enabled.
   * 
   *
   * @param button - index of the button clicked to update.
   * @param letter - letter that should be updated.
   */
  public void updateView(int button, String letter) {
    ((JButton) this.boardLayout.getComponent(button)).setText(letter);
    ((JButton) this.boardLayout.getComponent(button)).setEnabled(false);
    this.validate();
    String playerTurn;
    if (letter.equals("X")) {
      playerTurn = "O";
    } else {
      playerTurn = "X";
    }
    setPlayerText(playerTurn);

  }

  /**
   * 
   * Creates the JButtons.
   *
   * @param model - reference to the class that contains game play
   *        functionality.
   */
  private void createButtonsPanel() {
    this.boardLayout = new JPanel();
    this.boardLayout.setLayout(new GridLayout(3, 3));
    for (int i = 0; i < buttons.length; i++) {
      buttons[i] = new JButton();
      buttons[i].setName(i + "");
      ButtonListener click = new ButtonListener();
      buttons[i].addActionListener(click);
      boardLayout.add(buttons[i]);
    }
    this.add(this.boardLayout);
  }
}
