package org.pktomojapasja.zwierzeglebackend.api.auth;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.pktomojapasja.zwierzeglebackend.domain.users.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@SecurityRequirement(name = "auth")
public class UserApi {
    private final UserService userService;

    @GetMapping("/current")
    public UserDto getUserDetails() {
        var user = userService.getCurrent();
        return UserDto.fromUser(user);
    }
}