package com.expence_tracking.app.configuration.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class PasswordMissMatchException extends RuntimeException
{
    public PasswordMissMatchException(String message)
    {
        super(message);
    }

}
