package pms.di.uoa.ecommerce.auctions.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pms.di.uoa.ecommerce.auctions.dto.AuthenticationResponse;
import pms.di.uoa.ecommerce.auctions.dto.LoginRequest;
import pms.di.uoa.ecommerce.auctions.dto.MessageResponse;
import pms.di.uoa.ecommerce.auctions.dto.RegisterRequest;
import pms.di.uoa.ecommerce.auctions.services.AuthService;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping
    public String message(){
        return "ok we can see it";
    }

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody RegisterRequest registerRequest) {
        authService.signup(registerRequest);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

//    @PostMapping("/login")
//    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
//        return authService.login(loginRequest);
//    }
}
