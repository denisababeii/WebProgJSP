package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;

public class Question {
    private int id;
    private String body;
    private String answer;
    private String firstIncorrectAnswer;
    private String secondIncorrectAnswer;

    public Question(int id, String body, String answer, String firstIncorrectAnswer, String secondIncorrectAnswer) {
        this.id = id;
        this.body = body;
        this.answer = answer;
        this.firstIncorrectAnswer = firstIncorrectAnswer;
        this.secondIncorrectAnswer = secondIncorrectAnswer;
    }

    public Question() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getFirstIncorrectAnswer() {
        return firstIncorrectAnswer;
    }

    public void setFirstIncorrectAnswer(String firstIncorrectAnswer) {
        this.firstIncorrectAnswer = firstIncorrectAnswer;
    }

    public String getSecondIncorrectAnswer() {
        return secondIncorrectAnswer;
    }

    public void setSecondIncorrectAnswer(String secondIncorrectAnswer) {
        this.secondIncorrectAnswer = secondIncorrectAnswer;
    }

    public List<String> getAllAnswers() {
        var answers = new ArrayList<String>();
        answers.add(answer);
        answers.add(firstIncorrectAnswer);
        answers.add(secondIncorrectAnswer);
        Collections.shuffle(answers);
        return answers;
    }
}
