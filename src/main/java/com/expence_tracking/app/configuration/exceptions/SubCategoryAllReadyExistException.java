package com.expence_tracking.app.configuration.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class SubCategoryAllReadyExistException extends RuntimeException
{
    public SubCategoryAllReadyExistException(String message)
    {
        super(message);
    }
}
