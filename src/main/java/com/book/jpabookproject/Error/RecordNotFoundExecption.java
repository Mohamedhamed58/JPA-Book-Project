package com.book.jpabookproject.Error;

public class RecordNotFoundExecption extends RuntimeException{
    public RecordNotFoundExecption() {
    }

    public RecordNotFoundExecption(String message) {
        super(message);
    }
}
