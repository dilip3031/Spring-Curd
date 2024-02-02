package com.dileep.curd.handler;


import com.dileep.curd.utils.GeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class GenericExceptionHandler {

    //Custom exceptions
    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<Map<String, String>> handleGenericException(GeneralException e) {
        Map<String, String> result = new HashMap();
        result.put("error_code", e.errorCode);
        result.put("massage", e.massage);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleAllException(Exception e) {
        Map<String, String> result = new HashMap();
        result.put("error_code", "ERROR_000");
        result.put("massage", "Something went wrong please try again !!!");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }


}