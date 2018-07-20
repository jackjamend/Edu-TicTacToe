/**
 * QuestionReader.java 1.0 Jul 19, 2018
 *
 * Copyright (c) 2018 Jack Amend. All Rights Reserved
 * Elon University, Elon, NC 27144
 */
package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * Start each class or interface with summary description line
 *
 * @author Jack J Amend
 * @version 1.0
 *
 */
public class QuestionReader {

  private HashMap<String, ArrayList<String>> answerKey;

  public QuestionReader(File file) {
    answerKey = new HashMap<String, ArrayList<String>>();
    try {
      Scanner in = new Scanner(file);
      while (in.hasNextLine()) {
        String line = in.nextLine();
        int qMarkIndex = line.indexOf("?");
        String question = line.substring(0, qMarkIndex + 1);
        String answerString = line.substring(qMarkIndex + 1);
        ArrayList<String> answers = new ArrayList<String>();
        if (answerString.contains(",")) {
          int commaIndex = answerString.indexOf(",");
          while (commaIndex != -1) {
            answers.add(answerString.substring(0, commaIndex).trim());
            answerString = answerString.substring(commaIndex + 1);
            commaIndex = answerString.indexOf(",");
          }
          answers.add(answerString);
        } else {
          answers.add(answerString);
        }
        answerKey.put(question, answers);
      }
    } catch (FileNotFoundException e) {
      System.err.println("File could not be opened");
      System.exit(1);
    }

  }

  public HashMap<String, ArrayList<String>> getAnswerKey() {
    return answerKey;
  }

  public void printAnswerKey() {
    Iterator it = answerKey.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry<String, ArrayList<String>> values =
        (Map.Entry<String, ArrayList<String>>) it.next();
      ArrayList<String> answers = values.getValue();
      for (String answer : answers) {
        System.out.println(values.getKey() + " " + answer);
      }
    }
  }

}
