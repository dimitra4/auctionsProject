package pms.di.uoa.ecommerce.auctions.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pms.di.uoa.ecommerce.auctions.modeldb.Category;
import pms.di.uoa.ecommerce.auctions.repositories.CategoryRepository;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/category")
public class CategoryController {

    private final CategoryRepository categoryRepository;


    @Autowired
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public List<Category> category(){
        return categoryRepository.findAll();
    }
}
