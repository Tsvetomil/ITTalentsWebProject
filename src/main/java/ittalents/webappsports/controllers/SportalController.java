package ittalents.webappsports.controllers;

import ittalents.webappsports.exceptions.*;
import ittalents.webappsports.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@ControllerAdvice
public class SportalController {
    @ExceptionHandler({UserNotLoggedException.class})
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    public String handleUserException(){
        return "You are not logged in!";
    }

    @ExceptionHandler({NotAdminException.class})
    public String handleNotAdminException(){
        return "You are not admin!";
    }
    @ExceptionHandler({EmailAlreadyExist.class})
    public String sameEmail(){
        return "User with that email already exist";
    }
    @ExceptionHandler({UsernameAlreadyExist.class})
    public String sameUsername(){
        return "User with that username already exist";
    }
    @ExceptionHandler({WrongCredentialsException.class})
    public String wrongUsernameOrPassword(){
        return "Wrong username or password";
    }
    @ExceptionHandler({SQLException.class})
    public String handleSql(){
        return "something went wrong";
    }


}
