package com.BBD.BBDHack.Controllers;

import com.BBD.BBDHack.Models.Questions;
import com.BBD.BBDHack.Models.examples.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping(value = "/question", produces = MediaType.APPLICATION_JSON_VALUE)
    public Questions getQuestion(@RequestParam(value = "questionId",required = false) Integer id){
        return questionRepository.generateQuestion(id);
    }

    @GetMapping(value = "/result", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean getQuestion(@RequestParam(value = "questionId") Integer id,@RequestParam("answer") String answer){
        return questionRepository.checkResult(id,answer);
    }

}