package pms.di.uoa.ecommerce.auctions.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pms.di.uoa.ecommerce.auctions.handleExceptions.CreationDateGreaterThanEndDate;
import pms.di.uoa.ecommerce.auctions.handleExceptions.ItemNotFoundException;
import pms.di.uoa.ecommerce.auctions.modeldb.Items;
import pms.di.uoa.ecommerce.auctions.modeldb.Users;
import pms.di.uoa.ecommerce.auctions.repositories.ItemsRepository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ItemsService {

    private final ItemsRepository itemsRepository;

    @Autowired
    public ItemsService(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    public List<Items> getAllItems() {
        return itemsRepository.findAll();
    }

    public Items geItem(Long itemId) {
        Items item = itemsRepository.findById(itemId)
                .orElseThrow(() -> new ItemNotFoundException(itemId));
        return item;
    }

    public void addNewItem(Items item) {
        //String itemName = item.getItemName();
        //int categoryId = item.getCategoryId();
        //long creatorUserId = item.getCreatorUserId();
        Date creationDate = item.getCreationDate();
        Date endDate = item.getEndDate();
        Users user = item.getUsersByCreatorUserId();
        //String itemCountry = item.getItemCountry();
        //String itemItemLocation = item.getItemLocation();
        //BigDecimal firstBid = item.getFirstBid();
        //String imagePath = item.getImagePath();

        if (creationDate.compareTo(endDate) > 0) {
            throw new CreationDateGreaterThanEndDate();
        }
        itemsRepository.save(item);
    }

    //to delete an item if exists
    public void deleteItem(Long itemId) {
        boolean exists = itemsRepository.existsById(itemId);
        if(!exists){
            throw new ItemNotFoundException(itemId);
        }
        //to do check if there is no bid for this auction, αν υπάρχει να βγάζει κατάλληλο exception
        itemsRepository.deleteById(itemId);
    }

    @Transactional
    public void updateItem(Long itemId,
                           String itemName,
                           int categoryId,
                           Date endDate,
                           String itemCountry,
                           String itemItemLocation,
                           BigDecimal firstBid,
                           String imagePath
    ) {
        Items item  = itemsRepository.findById(itemId)
                .orElseThrow(() -> new ItemNotFoundException(itemId));
        //to do check if there is no bid for this auction, αν υπάρχει να βγάζει κατάλληλο exception

        Date creationDate = item.getCreationDate();
        if (creationDate.compareTo(endDate) > 0) {
            throw new CreationDateGreaterThanEndDate();
        }
        if(itemName != null &&
                itemName.length()>0 && !Objects.equals(item.getItemName(), itemName)){
            item.setItemName(itemName);
        }
        if(!Objects.equals(item.getCategoryId(), categoryId)){
            item.setCategoryId(categoryId);
        }
        if(itemItemLocation != null &&
                itemItemLocation.length()>0 && !Objects.equals(item.getItemLocation(), itemItemLocation)){
            item.setItemLocation(itemItemLocation);
        }
        if(itemCountry != null &&
                itemCountry.length()>0 && !Objects.equals(item.getItemCountry(), itemCountry)){
            item.setItemCountry(itemCountry);
        }
        if(imagePath != null &&
                imagePath.length()>0 && !Objects.equals(item.getImagePath(), imagePath)){
            item.setImagePath(imagePath);
        }
        if(firstBid != null ){
            item.setFirstBid(firstBid);
        }
    }

}
