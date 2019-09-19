package com.BBD.BBDHack.Models.examples;

import com.BBD.BBDHack.Models.Answer;
import com.BBD.BBDHack.Models.Questions;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuestionRepository {

    private List<Questions> questions = new ArrayList<Questions>();

    public QuestionRepository() {
    }

    public Questions generateQuestion(Integer id){
        initialseQuestion();
        Questions example;
        if (Objects.isNull(id)) {
            example = questions.get((int) (Math.random()*questions.size()));
        }else {
            example = questions.stream().filter(questions1 -> questions1.getQuestionID() == (id)).findFirst().get();
        }
        ArrayList randomisedAnswer = new ArrayList<>(example.getAnswers());
        Collections.shuffle(randomisedAnswer);
        return example.cloneQuestion(randomisedAnswer);

    }

    public boolean checkResult(Integer questionId, String answer){
        Questions example;
        if (Objects.isNull(questionId)) {
            example = questions.get(0);
        }else {
            example = questions.stream().filter(questions1 -> questions1.getQuestionID() == (questionId)).findFirst().get();
        }
        String[] userAnswer = answer.split("_");
        List<Answer> actualAnswer = example.getAnswers();
        if (actualAnswer.size()!=userAnswer.length){
            return false;
        }
        for (int i=0;i<actualAnswer.size();i++){
            if (actualAnswer.get(i).getSeqNo() != Integer.parseInt(userAnswer[i])){
                return false;
            }
        }
        return true;
    }



    public void initialseQuestion(){
        this.questions.clear();
        Answer firstAnswer = new Answer(1,"String a = \"racecar\", b = \"\";");
        Answer secondAnswer = new Answer(2,"int n = a.length();");
        Answer thirdAnswer = new Answer(3,"for(int i = n - 1; i >= 0; i--)  b = b + a.charAt(i);");
        Answer forthAnswer = new Answer(4,"if(a.equalsIgnoreCase(b))  System.out.println(\"The string is palindrome.\");");
        Answer fifthAnswer = new Answer(5,"else  System.out.println(\"The string is not palindrome.\");");
        List<Answer> answers = new LinkedList<Answer>();
        answers.add(firstAnswer);
        answers.add(secondAnswer);
        answers.add(thirdAnswer);
        answers.add(forthAnswer);
        answers.add(fifthAnswer);
        Questions questions = new Questions(1,"Check whether a racecar is a Palindrome",answers);
        this.questions.add(questions);
        firstAnswer = new Answer(1,"String out=\"\"");
        secondAnswer = new Answer(2,"for (int i=0;i<5;i++)");
        thirdAnswer = new Answer(3,"for (int j=0;j<=i;j++)");
        forthAnswer = new Answer(4,"out=out+\"x\"");
        fifthAnswer = new Answer(5,"out = out +\\n");
        answers = new LinkedList<>();
        answers.add(firstAnswer);
        answers.add(secondAnswer);
        answers.add(thirdAnswer);
        answers.add(forthAnswer);
        answers.add(fifthAnswer);
        questions = new Questions(2,"Build a pyramid of x's, with 5 layers using a for loop",answers);
        this.questions.add(questions);
        firstAnswer = new Answer(1,"int a = 10; int b =15;");
        secondAnswer = new Answer(2,"if (a>=b)");
        thirdAnswer = new Answer(3,"return a");
        forthAnswer = new Answer(4,"else");
        fifthAnswer = new Answer(5,"return b");
        answers = new LinkedList<>();
        answers.add(firstAnswer);
        answers.add(secondAnswer);
        answers.add(thirdAnswer);
        answers.add(forthAnswer);
        answers.add(fifthAnswer);
        questions = new Questions(3,"How would you determine the larger of two integers?",answers);
        this.questions.add(questions);
    }
}
