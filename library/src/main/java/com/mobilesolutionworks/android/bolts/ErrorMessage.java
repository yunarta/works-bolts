package com.mobilesolutionworks.android.bolts;

/**
 * Created by yunarta on 25/9/14.
 */
public class ErrorMessage extends Exception {

    public ErrorMessage(String detailMessage) {
        super(detailMessage);
    }

    public ErrorMessage(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }
}
