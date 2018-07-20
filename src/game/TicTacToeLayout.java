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
import javax.swing.JTextField;
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
  private JTextField answerTextBox;
  private JPanel boardLayout;
  private JButton[] buttons = new JButton[9];
  private JLabel playerLabel;
  private JLabel question;
  private JPanel questionPanel;
  private JPanel responsePanel;

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

    answer = new JLabel("Answer: ");
    answerTextBox = new JTextField();
    answerTextBox.setText("Type answer here...");
    answerTextBox.addActionListener(new AnswerListener());
    answerTextBox.addFocusListener(new AnswerFocusListener());
    responsePanel = new JPanel();
    responsePanel.setLayout(new BorderLayout());
    responsePanel.add(answerTextBox, BorderLayout.CENTER);
    responsePanel.add(answer, BorderLayout.WEST);

    questionPanel = new JPanel();
    question = new JLabel("Question: ");
    questionPanel.setLayout(new GridLayout(2, 1));
    questionPanel.add(question);
    questionPanel.add(responsePanel);
    add(questionPanel, BorderLayout.SOUTH);
  }

  public void clearAnswerBox() {
    this.answerTextBox.setText("");
  }

  public void disableAllButtons() {
    for (int i = 0; i < 9; i++) {
      ((JButton) this.boardLayout.getComponent(i)).setEnabled(false);
    }
    this.validate();
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

  public void setQuestion(String question) {
    this.question.setText("Question: " + question);
  }

  public void updateButtons(boolean enable, int[] indexs) {
    this.playerLabel.setText("Correct!");
    for (int i : indexs) {
      ((JButton) this.boardLayout.getComponent(i)).setEnabled(enable);
    }
    this.validate();

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

  public void wrongAnswer(String player) {
    this.playerLabel.setText("Sorry, incorrect answer. Player " + player
                             + " turn.");
    this.answerTextBox.setText("");
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
      buttons[i].setEnabled(false);
      boardLayout.add(buttons[i]);
    }
    this.add(this.boardLayout);
  }
}
