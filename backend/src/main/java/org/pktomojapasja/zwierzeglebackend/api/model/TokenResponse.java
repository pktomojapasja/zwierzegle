package org.pktomojapasja.zwierzeglebackend.api.model;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(staticName = "of")
public class TokenResponse {
    String token;
}