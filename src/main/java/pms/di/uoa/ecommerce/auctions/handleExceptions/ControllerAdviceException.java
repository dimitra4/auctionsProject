package pms.di.uoa.ecommerce.auctions.handleExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerAdviceException {

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String userNotFoundException(UserNotFoundException ex){
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(ImageNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String imageNotFoundException(ImageNotFoundException ex){
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(TakenException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public String takenException(TakenException ex){
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(ItemNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String itemNotFoundException(ItemNotFoundException ex){
        return ex.getMessage();
    }


    @ResponseBody
    @ExceptionHandler(CreationDateGreaterThanEndDate.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String creationDateGreaterThanEndDate(CreationDateGreaterThanEndDate ex){
        return ex.getMessage();
    }


}
