package org.pktomojapasja.zwierzeglebackend.api.auth;

import lombok.Value;
import org.pktomojapasja.zwierzeglebackend.domain.users.User;

@Value
class UserDto {
    Long id;
    String email;
    String type;

    static UserDto fromUser(User user) {
        return new UserDto(user.getId(), user.getEmail(), user.getType().name());
    }
}