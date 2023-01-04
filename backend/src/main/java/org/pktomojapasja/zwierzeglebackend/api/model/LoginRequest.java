package org.pktomojapasja.zwierzeglebackend.api.model;

import lombok.Value;

@Value
public class LoginRequest {
    String email;
    String password;
}