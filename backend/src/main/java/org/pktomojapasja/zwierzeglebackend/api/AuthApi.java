package org.pktomojapasja.zwierzeglebackend.api;


import lombok.RequiredArgsConstructor;
import org.pktomojapasja.zwierzeglebackend.api.model.LoginRequest;
import org.pktomojapasja.zwierzeglebackend.api.model.RegistrationRequest;
import org.pktomojapasja.zwierzeglebackend.api.model.TokenResponse;
import org.pktomojapasja.zwierzeglebackend.data.user.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthApi {
    private final UserService userService;

    @PostMapping("/register")
    public TokenResponse register(RegistrationRequest registrationRequest) {
        String token = userService.register(registrationRequest.toUser());
        return TokenResponse.of(token);
    }

    @PostMapping("/login")
    public TokenResponse login(LoginRequest loginRequest) {
        String token = userService.login(loginRequest);
        return TokenResponse.of(token);
    }
}