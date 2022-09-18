package pms.di.uoa.ecommerce.auctions.handleExceptions;

public class TakenException extends RuntimeException{

    public TakenException(String takenException){
        super(takenException + " is taken. You cannot use it. Please change it!");
    }
}
