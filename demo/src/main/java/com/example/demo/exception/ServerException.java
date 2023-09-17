package com.example.demo.exception;

public class ServerException extends RuntimeException {

    public ServerException() {}

    public ServerException(Throwable e) {
        super(e);
    }

}
