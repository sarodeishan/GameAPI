package com.BBD.BBDHack.Models;

import java.util.LinkedList;
import java.util.List;


public class Questions {

    private List<Answer> answers = new LinkedList<Answer>();

    private String question;

    private int questionID;

    public Questions(int id, String question, List answers) {
        this.questionID=id;
        this.question=question;
        this.answers =answers;
    }

    public Questions cloneQuestion(List answers){
        return new Questions(this.questionID,this.question,answers);
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

}
