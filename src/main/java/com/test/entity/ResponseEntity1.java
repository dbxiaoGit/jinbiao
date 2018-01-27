package com.test.entity;

import java.util.List;

/**
 * Created by x on 2018/1/27.
 */

public class ResponseEntity1 {
    private boolean result;
    private List<Question> data;

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public List<Question> getData() {
        return data;
    }

    public void setData(List<Question> data) {
        this.data = data;
    }
}
