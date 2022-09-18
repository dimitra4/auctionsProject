package pms.di.uoa.ecommerce.auctions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pms.di.uoa.ecommerce.auctions.modeldb.Users;

import java.util.Optional;

@Repository
public interface UserRepository
        extends JpaRepository<Users, Long>{

    @Query("SELECT u FROM Users u where u.username = ?1")
    Optional<Users> findUserByUsername(String username);

    @Query("SELECT u FROM Users u where u.email = ?1")
    Optional<Users> findUserByEmail(String email);
}
