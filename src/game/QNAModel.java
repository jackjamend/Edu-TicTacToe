/**
 * QNAModel.java 1.0 Jul 19, 2018
 *
 * Copyright (c) 2018 Jack Amend. All Rights Reserved
 * Elon University, Elon, NC 27144
 */
package game;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Start each class or interface with summary description line
 *
 * @author Jack J Amend
 * @version 1.0
 *
 */
public class QNAModel {

  private static HashMap<String, ArrayList<String>> answerKey;
  private static String[] currentQNA;
  private static HashMap<String, ArrayList<String>> unusedQuestions;

  public QNAModel(File file) {
    QNAModel.answerKey = new QuestionReader(file).getAnswerKey();
    QNAModel.unusedQuestions =
      new HashMap<String, ArrayList<String>>(QNAModel.answerKey);
  }

  public boolean answerQuestion(String answer) {
    for (int i = 1; i < QNAModel.currentQNA.length; i++) {
      if (currentQNA[i].trim().equals(answer.trim())) {
        return true;
      }
    }
    return false;
  }

  public String getCurrentQuestion() {
    if (QNAModel.unusedQuestions.isEmpty()) {
      QNAModel.unusedQuestions =
        new HashMap<String, ArrayList<String>>(QNAModel.answerKey);
    }
    String[] keyList =
      unusedQuestions.keySet()
                     .toArray(new String[unusedQuestions.keySet().size()]);

    int index = (int) ((keyList.length - 1) * Math.random());
    String usedKey = keyList[index];

    ArrayList<String> response = QNAModel.unusedQuestions.get(usedKey);
    response.add(0, usedKey);
    QNAModel.unusedQuestions.remove(usedKey);
    QNAModel.currentQNA =
      (String[]) response.toArray(new String[response.size()]);
    return QNAModel.currentQNA[0];
  }

  private HashMap<String, ArrayList<String>> copyArray() {
    return QNAModel.answerKey;
  }

}
