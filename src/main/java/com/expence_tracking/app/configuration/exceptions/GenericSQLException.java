package com.expence_tracking.app.configuration.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class GenericSQLException extends RuntimeException
{
    public GenericSQLException(String message)
    {
        super(message);
    }
}
