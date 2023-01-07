package org.pktomojapasja.zwierzeglebackend.api.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Value;
import org.pktomojapasja.zwierzeglebackend.api.Constraints;
import org.pktomojapasja.zwierzeglebackend.domain.users.User;

@Value
class RegistrationRequest {
    @Email
    String email;
    String password;
    @Pattern(regexp = Constraints.TYPE_PATTERN)
    String type;

    public User toUser() {
        return User.builder()
                .email(email)
                .password(password)
                .type(User.Type.valueOf(type.toUpperCase()))
                .build();
    }
}