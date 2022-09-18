package pms.di.uoa.ecommerce.auctions.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pms.di.uoa.ecommerce.auctions.handleExceptions.ImageNotFoundException;
import pms.di.uoa.ecommerce.auctions.handleExceptions.UserNotFoundException;
import pms.di.uoa.ecommerce.auctions.modeldb.Images;
import pms.di.uoa.ecommerce.auctions.modeldb.Users;
import pms.di.uoa.ecommerce.auctions.repositories.ImageRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ImageService {

    private final ImageRepository imageRepository;

    @Autowired
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    //get all images
    public List<Images> getAll(){
        return imageRepository.findAll();
    }

    //get a specific image
    public Images getImage(int imageId) {
        Images image  = imageRepository.findById(imageId)
                .orElseThrow(() -> new ImageNotFoundException(imageId));
        return image;
    }

    //delete an image
    public void deleteImage(int imageId) {
        boolean exists = imageRepository.existsById(imageId);
        if(!exists){
            throw new ImageNotFoundException(imageId);
        }
        imageRepository.deleteById(imageId);
    }

    //save an image
    public void addNewImage(Images image){
        imageRepository.save(image);
    }

    @Transactional
    public Images replaceImage(Images newImage, int imageId){
        Images image = imageRepository.findById(imageId)
                .map(Image -> {
                    Image.setImagePath(newImage.getImagePath());
                    return imageRepository.save(Image);
                })
                .orElseGet(() -> {
                    newImage.setImageId(imageId);
                    return imageRepository.save(newImage);
                });
        return image;
    }
}
