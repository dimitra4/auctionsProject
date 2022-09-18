package pms.di.uoa.ecommerce.auctions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pms.di.uoa.ecommerce.auctions.modeldb.Images;

public interface ImageRepository extends JpaRepository<Images, Integer> {
}
