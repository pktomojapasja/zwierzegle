package org.pktomojapasja.zwierzeglebackend.api.auth;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(staticName = "of")
class TokenResponse {
    String token;
}