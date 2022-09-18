package pms.di.uoa.ecommerce.auctions.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pms.di.uoa.ecommerce.auctions.handleExceptions.TakenException;
import pms.di.uoa.ecommerce.auctions.handleExceptions.UserNotFoundException;
import pms.di.uoa.ecommerce.auctions.modeldb.Users;
import pms.di.uoa.ecommerce.auctions.repositories.UserRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //get all existing Users in the repository(DB)
    public List<Users> getUsers(){
        return userRepository.findAll();
    }

    public Users getUser(Long userId) {
        Users user  = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
        return user;
    }

    //call methods from repository to check id email and username are taken, otherwise add user
    public void addNewUser(Users user){
        String username = user.getUsername();
        String email = user.getEmail();
        Optional<Users> userByUsername = userRepository
                .findUserByUsername(username);
        if (userByUsername.isPresent()){
            throw new TakenException("Username " + username);
        }
        Optional<Users> userByEmail = userRepository
                .findUserByEmail(email);
        if (userByEmail.isPresent()){
            throw new TakenException("Email "+  email);
        }
        userRepository.save(user);
    }

    //to delete a user if exists
    public void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if(!exists){
            throw new UserNotFoundException(userId);
        }
        userRepository.deleteById(userId);
    }

    //to update the profile of a user
    @Transactional
    public void updateUser(Long userId,
                           String passwordId,
                           String fullname,
                           String email,
                           String telNumber,
                           String country,
                           String location
                           ) {
        Users user  = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
        if(passwordId != null &&
                passwordId.length()>0 && !Objects.equals(user.getPasswordId(), passwordId)){
            user.setPasswordId(passwordId);
        }
        if(fullname != null &&
                fullname.length()>0 && !Objects.equals(user.getFullname(), fullname)){
            user.setFullname(fullname);
        }
        if(email != null &&
                email.length()>0 && !Objects.equals(user.getEmail(), email)){
            Optional<Users> userOptional = userRepository
                    .findUserByEmail(email);
            if (userOptional.isPresent()){
                throw new TakenException("Email "+  email);
            }
            user.setEmail(email);
        }
        if(telNumber != null &&
                telNumber.length()>0 && !Objects.equals(user.getTelNumber(), telNumber)){
            user.setTelNumber(telNumber);
        }
        if(country != null &&
                country.length()>0 && !Objects.equals(user.getCountry(), country)){
            user.setCountry(country);
        }
        if(location != null &&
                location.length()>0 && !Objects.equals(user.getLocation(), location)){
            user.setLocation(location);
        }
    }



}
