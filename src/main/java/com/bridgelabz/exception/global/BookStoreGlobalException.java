package com.bridgelabz.exception.global;

import com.bridgelabz.dto.ResponseDTO;
import com.bridgelabz.exception.custom.BadRequestException;
import com.bridgelabz.exception.custom.BookNotFoundException;
import com.bridgelabz.exception.custom.BookStoreCustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookStoreGlobalException {
    @ExceptionHandler({BookStoreCustomException.class})
    public ResponseEntity<ResponseDTO> handleEmployeeCustomException(BookStoreCustomException exception) {
        ResponseDTO responseDto = new ResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        return new ResponseEntity<>(responseDto, responseDto.getHttpStatus());
    }

    @ExceptionHandler({BookNotFoundException.class})
    public ResponseEntity<ResponseDTO> handleEmployeeNotFoundException(BookNotFoundException exception) {
        ResponseDTO responseDto = new ResponseDTO(HttpStatus.NOT_FOUND, exception.getMessage());
        return new ResponseEntity<>(responseDto, responseDto.getHttpStatus());
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<ResponseDTO> handleBadRequestException(BadRequestException exception) {
        ResponseDTO responseDto = new ResponseDTO(HttpStatus.BAD_REQUEST, exception.getMessage());
        return new ResponseEntity<>(responseDto, responseDto.getHttpStatus());
    }
}
