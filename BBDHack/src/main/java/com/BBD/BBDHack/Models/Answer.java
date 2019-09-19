package com.BBD.BBDHack.Models;

public class Answer {

    private int seqNo;

    private String answer;

    public Answer(int seqNo, String answer) {
        this.seqNo = seqNo;
        this.answer = answer;
    }

    public int getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(int seqNo) {
        this.seqNo = seqNo;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
