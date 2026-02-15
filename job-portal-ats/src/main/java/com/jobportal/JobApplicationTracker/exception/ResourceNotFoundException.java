package com.jobportal.JobApplicationTracker.exception;

public class ResourceNotFoundException extends RuntimeException {

    // Default constructor
    public ResourceNotFoundException() {
        super("Resource Not Found");
    }

    // Message constructor
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
