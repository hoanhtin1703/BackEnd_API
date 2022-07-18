package com.example.demo.model;

public class FileRespone {
    public FileRespone(String filename, String message) {
        this.filename = filename;
        this.message = message;
    }

    String filename;
    String message;

    public String getFilename() {
        return filename;
    }

    public String getMessage() {
        return message;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public FileRespone() {
    }
}
