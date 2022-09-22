package pms.di.uoa.ecommerce.auctions.services;

import lombok.AllArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pms.di.uoa.ecommerce.auctions.dto.AuthenticationResponse;
import pms.di.uoa.ecommerce.auctions.dto.LoginRequest;
import pms.di.uoa.ecommerce.auctions.dto.RegisterRequest;
import pms.di.uoa.ecommerce.auctions.modeldb.Users;
import pms.di.uoa.ecommerce.auctions.repositories.UserRepository;

import javax.transaction.Transactional;

import static java.time.Instant.now;

@Service
@AllArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder  passwordEncoder;

    @Transactional
    public void signup(RegisterRequest registerRequest) {
        Users user = new Users();
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPasswordId(passwordEncoder.encode(registerRequest.getPassword()));
        user.setFullname(registerRequest.getFullname());
        user.setTelNumber(registerRequest.getTelNumber());
        user.setCountry(registerRequest.getCountry());
        user.setLocation(registerRequest.getLocation());
        user.setRegistrationDate(now());
        user.setEnabled(true);

        userRepository.save(user);
    }
}
