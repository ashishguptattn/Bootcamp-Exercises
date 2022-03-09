package com.restfulservices.restfulwebservices.exception;

import java.util.Date;

public class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String details;



    public ExceptionResponse(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.details=details;
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getDetails() {
        return details;
    }
}
