package pms.di.uoa.ecommerce.auctions.handleExceptions;

public class CreationDateGreaterThanEndDate extends RuntimeException {

    public CreationDateGreaterThanEndDate() {
        super("Creation Date cannot be after End date of the auction!");
    }
}
