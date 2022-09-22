package pms.di.uoa.ecommerce.auctions.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pms.di.uoa.ecommerce.auctions.modeldb.Users;
import pms.di.uoa.ecommerce.auctions.repositories.UserRepository;

import java.util.Optional;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository applicationUserRepository;

    public UserDetailsServiceImpl(UserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> applicationUser = applicationUserRepository.findUserByUsername(username);
        Users user = applicationUser
                .orElseThrow(() -> new UsernameNotFoundException("No user " +
                        "Found with username : " + username));
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security
                .core.userdetails.User(user.getUsername(), user.getPasswordId(), emptyList());
    }
}


