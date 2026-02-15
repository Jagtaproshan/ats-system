package com.jobportal.JobApplicationTracker.exception;

public class BadRequestException extends RuntimeException {

    // Default constructor
    public BadRequestException() {
        super("Bad Request - Invalid input data");
    }

    // Custom message constructor
    public BadRequestException(String message) {
        super(message);
    }
}
