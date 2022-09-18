package pms.di.uoa.ecommerce.auctions.handleExceptions;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(Long itemId) {
        super("Image with id " + itemId + " does not exists in the system!");
    }
}
