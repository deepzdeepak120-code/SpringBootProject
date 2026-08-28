package Exception;


import Pojo.ErrorTemplate;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

//    ErrorTemplate errorTemplate = new ErrorTemplate();

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorTemplate> handleValidationExceptionsForStudentFields(MethodArgumentNotValidException  e, HttpServletRequest request)
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
        errorTemplate.setPath(request.getRequestURI());
        errorTemplate.setTimestamp(LocalDateTime.now());
        return ResponseEntity.badRequest().body(errorTemplate);
    }


@ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorTemplate> handleStudentNotFound(StudentNotFoundException e ,HttpServletRequest request){

    ErrorTemplate errorTemplate = new ErrorTemplate();

    Map<String,String> errors =new HashMap<>();
    errors.put("errors",e.getMessage());

    errorTemplate.setStatus(404);
    errorTemplate.setError("Student Not found");
    errorTemplate.setTimestamp(LocalDateTime.now());
    errorTemplate.setMessages(errors);
    errorTemplate.setPath(request.getRequestURI());

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorTemplate);

    }









}
