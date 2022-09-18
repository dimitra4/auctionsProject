package pms.di.uoa.ecommerce.auctions.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pms.di.uoa.ecommerce.auctions.services.UserService;
import pms.di.uoa.ecommerce.auctions.modeldb.Users;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<Users> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("{userId}")
    public Users one(@PathVariable("userId") Long userId) {

        return userService.getUser(userId);

    }

    @PostMapping
    public void registerNewUser(@RequestBody Users user){
        userService.addNewUser(user);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
    }

    @PutMapping(path = "{userId}")
    public void updateUser(
            @PathVariable("userId") Long userId,
            @RequestParam(required = false) String passwordId,
            @RequestParam(required = false) String fullname,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String telNumber,
            @RequestParam(required = false) String country,
            @RequestParam(required = false) String location) {
        userService.updateUser(userId, passwordId, fullname, email, telNumber, country, location);
    }

}
