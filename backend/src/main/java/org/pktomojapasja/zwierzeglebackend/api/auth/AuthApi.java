package org.pktomojapasja.zwierzeglebackend.api.auth;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.pktomojapasja.zwierzeglebackend.domain.users.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthApi {
    private final UserService userService;

    @PostMapping("/register")
    public TokenResponse register(@RequestBody @Valid RegistrationRequest registrationRequest) {
        String token = userService.register(registrationRequest.toUser());
        return TokenResponse.of(token);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid LoginRequest loginRequest) {
        String token = userService.login(loginRequest.toCredentials());
        return TokenResponse.of(token);
    }
}