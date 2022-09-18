package pms.di.uoa.ecommerce.auctions.modeldb;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@NoArgsConstructor
public class Images {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "image_id", nullable = false)
    private int imageId;
    @Basic
    @Column(name = "image_path", nullable = true, length = 255)
    private String imagePath;
    @Basic
    @Column(name = "item_id", nullable = true)
    private Long itemId;

    public Images(String path) {
        this.imagePath = imagePath;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Images images = (Images) o;
        return imageId == images.imageId && Objects.equals(imagePath, images.imagePath) && Objects.equals(itemId, images.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imageId, imagePath, itemId);
    }

}
