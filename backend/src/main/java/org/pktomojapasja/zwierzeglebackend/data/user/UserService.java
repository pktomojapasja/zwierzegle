package org.pktomojapasja.zwierzeglebackend.data.user;

import lombok.RequiredArgsConstructor;
import org.pktomojapasja.zwierzeglebackend.api.model.LoginRequest;
import org.pktomojapasja.zwierzeglebackend.config.JWTUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepo;
    private final JWTUtil jwtUtil;
    private final AuthenticationManager authManager;
    private final PasswordEncoder passwordEncoder;

    public String register(User user) {
        String encodedPass = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPass);
        user = userRepo.save(user);
        return jwtUtil.generateToken(user.getEmail());
    }

    public String login(LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken authInputToken =
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword());
        authManager.authenticate(authInputToken);
        return jwtUtil.generateToken(loginRequest.getEmail());
    }
}