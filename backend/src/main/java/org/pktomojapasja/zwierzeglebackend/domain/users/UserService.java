package org.pktomojapasja.zwierzeglebackend.domain.users;

import lombok.RequiredArgsConstructor;
import org.pktomojapasja.zwierzeglebackend.config.JWTUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final JWTUtil jwtUtil;
    private final AuthenticationManager authManager;
    private final PasswordEncoder passwordEncoder;

    public String register(User user) {
        String encodedPass = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPass);
        user = userRepository.save(user);
        return jwtUtil.generateToken(user.getEmail());
    }

    public String login(Credentials credentials) {
        UsernamePasswordAuthenticationToken authInputToken =
                new UsernamePasswordAuthenticationToken(credentials.getEmail(), credentials.getPassword());
        authManager.authenticate(authInputToken);
        return jwtUtil.generateToken(credentials.getEmail());
    }

    public User getCurrent() {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findByEmail(email).orElseThrow();
    }
}