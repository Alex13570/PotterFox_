package ru.loonolud.potterfox.exceptions.file;

public class FileProcessingException extends RuntimeException {

    public FileProcessingException(String msg) {
        super(msg);
    }

    public FileProcessingException() {
        super("Unable process file!");
    }

}
