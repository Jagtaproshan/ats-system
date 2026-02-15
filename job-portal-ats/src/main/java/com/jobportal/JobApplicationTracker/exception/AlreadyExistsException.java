package com.jobportal.JobApplicationTracker.exception;

public class AlreadyExistsException extends RuntimeException {

    // Default constructor
    public AlreadyExistsException() {
        super("Resource already exists");
    }

    // Custom message constructor
    public AlreadyExistsException(String message) {
        super(message);
    }
}
