package org.romans.controller;

import org.romans.exceptions.InvalidArabicNumberException;
import org.romans.exceptions.InvalidRomanNumeralException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ManejoDeExcepciones {

    @ExceptionHandler(InvalidArabicNumberException.class)
    public ResponseEntity<String> handleArabicNumberException(InvalidArabicNumberException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Número árabe inválido: " + ex.getMessage());
    }

    @ExceptionHandler(InvalidRomanNumeralException.class)
    public ResponseEntity<String> handleRomanNumeralException(InvalidRomanNumeralException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Número romano inválido: " + ex.getMessage());
    }

}

