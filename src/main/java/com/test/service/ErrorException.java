package com.test.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by x on 2018/1/27.
 */

@ResponseStatus(code= HttpStatus.BAD_REQUEST,reason="问题或答案不对")
public class ErrorException extends Exception {
    Logger logger = LoggerFactory.getLogger(getClass());
    public ErrorException(){
        super();
        logger.error("code:{}",HttpStatus.BAD_REQUEST);
    }
}
