package pms.di.uoa.ecommerce.auctions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pms.di.uoa.ecommerce.auctions.modeldb.Items;

public interface ItemsRepository extends JpaRepository<Items, Long> {
}
