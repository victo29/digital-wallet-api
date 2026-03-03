package com.victortavares.infrastructure;

import com.victortavares.core.exception.*;
import com.victortavares.core.exception.enums.ErrorCodeEnum;
import com.victortavares.infrastructure.dto.response.BaseResponse;
import com.victortavares.infrastructure.dto.response.ErrorResponse;
import com.victortavares.infrastructure.dto.response.ValidationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.stream.Collectors;

@ControllerAdvice
public class HandleControllerAdivice {

   @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponse<ValidationError>> handleMethod(MethodArgumentNotValidException ex, WebRequest request){

        var error = new ErrorResponse(
                ErrorCodeEnum.RQ0001.getMessage(),
                ErrorCodeEnum.RQ0001.getCode(),
                ex.getBindingResult().getFieldErrors().stream()
                        .map(fieldError -> new ValidationError(fieldError.getField(), fieldError.getDefaultMessage()))
                        .collect(Collectors.toList())
        );

        return new ResponseEntity<>(BaseResponse.<ValidationError>builder().success(false).error(error).build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AuthenticateException.class)
    public ResponseEntity<BaseResponse<String>> handleAuthenticateException(AuthenticateException ex, WebRequest request){

        var error = new ErrorResponse(
                ex.getMessage(),
                ex.getCode(),
                null
        );

        return new ResponseEntity<>(BaseResponse.<String>builder().success(false).error(error).build(), HttpStatus.UNAUTHORIZED);
    }


    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BaseResponse<String>> handleBadRequestException(BadRequestException ex, WebRequest request){

        var error = new ErrorResponse(
                ex.getMessage(),
                ex.getCode(),
                null
        );

        return new ResponseEntity<>(BaseResponse.<String>builder().success(false).error(error).build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<BaseResponse<String>> handleInternalServerErrorException(InternalServerErrorException ex, WebRequest request){

        var error = new ErrorResponse(
                ex.getMessage(),
                ex.getCode(),
                null
        );

        return new ResponseEntity<>(BaseResponse.<String>builder().success(false).error(error).build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public  ResponseEntity<BaseResponse<String>> handleNotFoundException(NotFoundException ex, WebRequest request){

       var error = new ErrorResponse(
               ex.getMessage(),
               ex.getCode(),
               null
       );

       return new ResponseEntity<>(BaseResponse.<String>builder().success(false).error(error).build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotificationException.class)
    public  ResponseEntity<BaseResponse<String>> handleNotificationException(NotificationException ex, WebRequest request){

        var error = new ErrorResponse(
                ex.getMessage(),
                ex.getCode(),
                null
        );

        return new ResponseEntity<>(BaseResponse.<String>builder().success(false).error(error).build(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(TaxNumberException.class)
    public  ResponseEntity<BaseResponse<String>> handleTaxNumberException(TaxNumberException ex, WebRequest request){

        var error = new ErrorResponse(
                ex.getMessage(),
                ex.getCode(),
                null
        );

        return new ResponseEntity<>(BaseResponse.<String>builder().success(false).error(error).build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmailException.class)
    public  ResponseEntity<BaseResponse<String>> handleEmailException(EmailException ex, WebRequest request){

        var error = new ErrorResponse(
                ex.getMessage(),
                ex.getCode(),
                null
        );

        return new ResponseEntity<>(BaseResponse.<String>builder().success(false).error(error).build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TransferException.class)
    public ResponseEntity<BaseResponse<String>> handleTaxNumberException(TransferException ex, WebRequest request){

        var error = new ErrorResponse(
                ex.getMessage(),
                ex.getCode(),
                null
        );

        return new ResponseEntity<>(BaseResponse.<String>builder().success(false).error(error).build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<BaseResponse<String>> handleAuthenticationException( AuthenticationException ex, WebRequest request){

       var error = new ErrorResponse(
               ErrorCodeEnum.ATH0001.getMessage(),
               ErrorCodeEnum.ATH0001.getCode(),
               null
       );

        return new ResponseEntity<>(BaseResponse.<String>builder().success(false).error(error).build(), HttpStatus.UNAUTHORIZED);

    }
}
