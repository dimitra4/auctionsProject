package pms.di.uoa.ecommerce.auctions.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pms.di.uoa.ecommerce.auctions.handleExceptions.ItemNotFoundException;
import pms.di.uoa.ecommerce.auctions.modeldb.Items;
import pms.di.uoa.ecommerce.auctions.services.ItemsService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/items")
public class ItemController {

    private final ItemsService itemsService;

    @Autowired
    public ItemController(ItemsService itemsService) {
        this.itemsService = itemsService;
    }

    @GetMapping
    public List<Items> getItems() {
        return itemsService.getAllItems();
    }

    @GetMapping(("{itemId}"))
    public Items getItem(@PathVariable("itemId") Long itemId) {
        Items item = itemsService.geItem(itemId);
        return item;
    }

    @PostMapping
    public void addNewItem(@RequestBody Items item){
        itemsService.addNewItem(item);
    }

    @DeleteMapping(path = "{itemId}")
    public void deleteItem(@PathVariable("itemId") Long itemId){
        itemsService.deleteItem(itemId);
    }

    @PutMapping(path = "{itemId}")
    public void updateItem(
            @PathVariable("itemId") Long itemId,
            @RequestParam(required = false) String itemName,
            @RequestParam(required = false) int categoryId,
            @RequestParam(required = false) Date endDate,
            @RequestParam(required = false) String itemCountry,
            @RequestParam(required = false) String itemItemLocation,
            @RequestParam(required = false) BigDecimal firstBid,
            @RequestParam(required = false) String imagePath) {
        itemsService.updateItem(itemId, itemName, categoryId, endDate, itemCountry, itemItemLocation,firstBid, imagePath);
    }
}
