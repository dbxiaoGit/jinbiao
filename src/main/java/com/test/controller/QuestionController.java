package com.test.controller;

import com.test.entity.Question;
import com.test.entity.ResponseEntity1;
import com.test.service.ErrorException;
import com.test.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by x on 2018/1/27.
 */

@RestController
public class QuestionController {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private QuestionService questionService;

    @PostMapping(value="/checkAnswer" ,produces="application/json;charset=UTF-8")
    public ResponseEntity<ResponseEntity1> getResponse(@RequestBody Question question) throws ErrorException{
        logger.info("getResponse({})",question.toString());
        ResponseEntity1 responseEntity1 = questionService.queryResult(question);
        /*
        try {
            if (!responseEntity1.getResult()) {
                throw new ErrorException();
            }
        }  finally {
            return responseEntity1;
        }*/
        ResponseEntity responseEntity = null;
        if (responseEntity1.getResult()) {
            responseEntity = new ResponseEntity(responseEntity1, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity(responseEntity1, HttpStatus.BAD_REQUEST);
        }
        return responseEntity;

    }
}
