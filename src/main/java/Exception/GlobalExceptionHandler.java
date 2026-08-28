package Exception;


import Pojo.ErrorTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorTemplate> handleValidationExceptionsForStudentFields(MethodArgumentNotValidException  e)
    {
        Map<String, String> errors =new HashMap<>();

        e.getBindingResult().getFieldErrors().forEach
                ( error ->{
            errors.put(error.getField(),error.getDefaultMessage());

        });

        ErrorTemplate errorTemplate = new ErrorTemplate();

        errorTemplate.setStatus(400);
        errorTemplate.setError("Validation Error");
        errorTemplate.setMessages(errors);
        errorTemplate.setTimestamp(LocalDateTime.now());
        return ResponseEntity.badRequest().body(errorTemplate);
    }






}
