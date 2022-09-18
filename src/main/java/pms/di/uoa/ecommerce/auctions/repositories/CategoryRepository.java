package pms.di.uoa.ecommerce.auctions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pms.di.uoa.ecommerce.auctions.modeldb.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
