package com.test.entity;

/**
 * Created by x on 2018/1/27.
 */

public class Question {
    private String question;
    private String answer;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString(){
        return String.format("question:%s,answer:%s",question,answer);
    }
}
