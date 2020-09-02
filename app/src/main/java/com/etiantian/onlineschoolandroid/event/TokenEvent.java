package com.etiantian.onlineschoolandroid.event;

public class TokenEvent {
    int errorCode;
    String message;

    public TokenEvent(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }


}
