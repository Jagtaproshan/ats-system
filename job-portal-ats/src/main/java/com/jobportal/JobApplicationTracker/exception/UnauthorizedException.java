package com.jobportal.JobApplicationTracker.exception;

public class UnauthorizedException extends RuntimeException {

    // Default constructor
    public UnauthorizedException() {
        super("You are not authorized to access this resource");
    }

    // Custom message constructor
    public UnauthorizedException(String message) {
        super(message);
    }
}
