package tn.esprit.faroukboussaid.Aspect;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class HandlerExceptions {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public Map<String, String> handlerExcedption(
            IllegalArgumentException e) {
        Map<String,String> returnvalue = new HashMap<>();
        returnvalue.put("error",e.getMessage());
        return  returnvalue;
    }
}
