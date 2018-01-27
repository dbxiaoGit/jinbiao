package com.test.service;

import com.test.entity.Question;
import com.test.entity.ResponseEntity1;
import com.test.entity.TestQuestion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by x on 2018/1/27.
 */

@Service
public class QuestionService {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TestQuestion testQuestion;

    public ResponseEntity1 queryResult(Question question){
        logger.info("queryResult({})",question.toString());
        List<Question> resultList = testQuestion.getQuestionList();
        resultList = resultList.stream().filter(item ->
                item.getQuestion().equals(question.getQuestion())
        ).collect(Collectors.toList());
        ResponseEntity1 responseEntity1 = new ResponseEntity1();
        responseEntity1.setData(resultList);
        if(resultList.size() == 1 && resultList.get(0).getAnswer().trim().equals(question.getAnswer().trim())){
            responseEntity1.setResult(true);
        }else {
            responseEntity1.setResult(false);
        }
        return responseEntity1;
    }
}
