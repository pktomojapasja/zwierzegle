package org.pktomojapasja.zwierzeglebackend.api.auth;

import lombok.Value;
import org.pktomojapasja.zwierzeglebackend.domain.users.Credentials;

@Value
class LoginRequest {
    String email;
    String password;

    Credentials toCredentials() {
        return new Credentials(email, password);
    }
}