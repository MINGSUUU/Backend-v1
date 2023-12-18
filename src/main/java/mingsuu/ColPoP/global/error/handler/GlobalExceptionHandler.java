package mingsuu.ColPoP.global.error.handler;

import jakarta.servlet.http.HttpServletRequest;
import mingsuu.ColPoP.global.error.BasicException;
import mingsuu.ColPoP.global.error.ErrorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(BasicException.class)
    public ResponseEntity<ErrorMessage> globalExceptionHandler(HttpServletRequest request, BasicException e) {
        printError(request, e.getErrorCode().getMessage());
        ErrorMessage errorMessage = new ErrorMessage(e.getErrorCode().getMessage(), e.getErrorCode().getStatus());
        return new ResponseEntity<>(errorMessage, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    private void printError(HttpServletRequest request, String message) {
        log.error(request.getRequestURI());
        log.error(message);
    }
}
