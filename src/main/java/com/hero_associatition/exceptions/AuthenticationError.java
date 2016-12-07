package com.hero_associatition.exceptions;

/**
 * Created by markoreljic on 7.12.16..
 */
import javax.annotation.Nonnull;


public class AuthenticationError extends Exception {

    private static final long serialVersionUID = 1L;

    private final String errorCode;

    private final String errorMessage;

    public AuthenticationError(@Nonnull String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
