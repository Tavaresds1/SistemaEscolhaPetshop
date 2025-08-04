package main.java.com.example.backend.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

// Esta classe intercepta e manipula exceções de validação globalmente.
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        // Cria um mapa para armazenar os erros de validação.
        Map<String, String> errors = new HashMap<>();
        
        // Itera sobre todos os erros de validação e extrai o nome do campo e a mensagem de erro.
        ex.getBindingResult().getFieldErrors().forEach(error ->
            errors.put(error.getField(), error.getDefaultMessage()));
        
        // Retorna um ResponseEntity com o mapa de erros e o status HTTP 400 (Bad Request).
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
