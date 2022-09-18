package pms.di.uoa.ecommerce.auctions.handleExceptions;

public class ImageNotFoundException extends RuntimeException {
    public ImageNotFoundException(int imageId) {
        super("Image with id " + imageId + " does not exists in the system!");
    }
}
