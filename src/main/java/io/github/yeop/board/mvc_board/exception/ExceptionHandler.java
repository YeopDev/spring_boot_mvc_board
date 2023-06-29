package io.github.yeop.board.mvc_board.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public String defaultExceptionHandler(HttpServletRequest request, Exception exception, Model model){
        log.error("exception: ", exception);
        model.addAttribute("exception",exception);
        return "error/error_default";
    }
}
