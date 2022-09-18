package pms.di.uoa.ecommerce.auctions.handleExceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(Long userId){
        super("User with id " + userId + " does not exists in the system!");
    }
}
