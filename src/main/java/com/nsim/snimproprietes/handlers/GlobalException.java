package com.nsim.snimproprietes.handlers;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nsim.snimproprietes.exceptions.EntityNotFoundException;
import com.nsim.snimproprietes.exceptions.InvalidEntityException;

@ControllerAdvice
public class GlobalException extends RuntimeException {

    @ExceptionHandler(EntityNotFoundException.class)
    public String handlerNotFound(EntityNotFoundException ex, Model model) {

        ErrorResponseCode error = new ErrorResponseCode(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "L'entité n'existe pas.",
                ex.getMessage());

        model.addAttribute("error", error);
        return "exceptions/error-page";
    }

    @ExceptionHandler(InvalidEntityException.class)
    public String handlerInvalidException(InvalidEntityException ex, Model model) {
        // final HttpStatus status = HttpStatus.NOT_FOUND;

        ErrorResponseCode error = new ErrorResponseCode(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "L'entité n'est pas valide.",
                ex.getMessage());
        model.addAttribute("error", error);
        return "exceptions/error-page";
    }

    @ExceptionHandler(Exception.class)
    public String handlerException(Exception ex, Model model) {
        // final HttpStatus status = HttpStatus.NOT_FOUND;

        ErrorResponseCode error = new ErrorResponseCode(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Erreur inattendue.",
                ex.getMessage());
        model.addAttribute("error", error);

        return "exceptions/error-page";
    }
}
