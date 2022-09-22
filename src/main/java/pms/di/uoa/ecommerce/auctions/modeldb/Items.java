package pms.di.uoa.ecommerce.auctions.modeldb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Items {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "itm_id", nullable = false)
    private long itmId;
    @Basic
    @Column(name = "item_id", nullable = false)
    private long itemId;
    @Basic
    @Column(name = "item_name", nullable = false, length = 255)
    private String itemName;
    @Basic
    @Column(name = "category_id", nullable = false)
    private int categoryId;
    @Basic
    @Column(name = "creation_date", nullable = false)
    private Date creationDate;
    @Basic
    @Column(name = "end_date", nullable = true)
    private Date endDate;
    @Basic
    @Column(name = "item_location", nullable = true, length = 255)
    private String itemLocation;
    @Basic
    @Column(name = "item_country", nullable = true, length = 255)
    private String itemCountry;
    @Basic
    @Column(name = "first_bid", nullable = true, precision = 5)
    private BigDecimal firstBid;
    @Basic
    @Column(name = "image_path", nullable = true, length = 255)
    private String imagePath;

    @JsonIgnoreProperties("items")
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "creator_user_id", referencedColumnName = "user_id", nullable = false, insertable=false, updatable=false)
    private Users usersByCreatorUserId;

    public long getItmId() {
        return itmId;
    }

    public void setItmId(long itmId) {
        this.itmId = itmId;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getItemLocation() {
        return itemLocation;
    }

    public void setItemLocation(String itemLocation) {
        this.itemLocation = itemLocation;
    }

    public String getItemCountry() {
        return itemCountry;
    }

    public void setItemCountry(String itemCountry) {
        this.itemCountry = itemCountry;
    }

    public BigDecimal getFirstBid() {
        return firstBid;
    }

    public void setFirstBid(BigDecimal firstBid) {
        this.firstBid = firstBid;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Items items = (Items) o;
        return itmId == items.itmId && itemId == items.itemId && categoryId == items.categoryId && Objects.equals(itemName, items.itemName) && Objects.equals(creationDate, items.creationDate) && Objects.equals(endDate, items.endDate) && Objects.equals(itemLocation, items.itemLocation) && Objects.equals(itemCountry, items.itemCountry) && Objects.equals(firstBid, items.firstBid) && Objects.equals(imagePath, items.imagePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itmId, itemId, itemName, categoryId, creationDate, endDate, itemLocation, itemCountry, firstBid, imagePath);
    }

    public Users getUsersByCreatorUserId() {
        return usersByCreatorUserId;
    }

    public void setUsersByCreatorUserId(Users usersByCreatorUserId) {
        this.usersByCreatorUserId = usersByCreatorUserId;
    }
}
