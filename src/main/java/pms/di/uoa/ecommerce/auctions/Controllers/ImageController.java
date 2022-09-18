package pms.di.uoa.ecommerce.auctions.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pms.di.uoa.ecommerce.auctions.modeldb.Images;
import pms.di.uoa.ecommerce.auctions.services.ImageService;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(path = "api/v1/images")
public class ImageController {

    private static String UPLOADED_FOLDER = "C://temp//";

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    // Aggregate root

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("picture") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:/uploadStatus";
        }

        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER
                    + file.getOriginalFilename().replace(':', '.')
                    + new Random().nextInt(1 << 20)
            );
            Files.write(path, bytes);
            Images img = new Images(path.toString());
            imageService.addNewImage(img);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }

    @GetMapping
    public List<Images> getImages(){
        return imageService.getAll();
    }

    @GetMapping("{imageId}")
    public Images one(@PathVariable("imageId") int imageId) {
        return imageService.getImage(imageId);
    }

    @DeleteMapping(path = "{imageId}")
    public void deleteImage(int imageId){
        imageService.deleteImage(imageId);
    }

    @PostMapping
    public void addNewImage(@RequestBody Images image){
        imageService.addNewImage(image);
    }

    @PutMapping("{imageId}")
    public Images replaceImage(@RequestBody Images newImage,
                               @PathVariable("imageId") int imageId){
        return imageService.replaceImage(newImage, imageId);
    }

}
