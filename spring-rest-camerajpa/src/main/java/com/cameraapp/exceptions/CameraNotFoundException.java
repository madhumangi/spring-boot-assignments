package com.cameraapp.exceptions;

public class CameraNotFoundException extends RuntimeException {
    public CameraNotFoundException(String message) {
        super(message);
    }
}
