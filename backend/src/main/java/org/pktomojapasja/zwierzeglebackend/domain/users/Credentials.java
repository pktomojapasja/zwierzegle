package org.pktomojapasja.zwierzeglebackend.domain.users;

import lombok.Value;

@Value
public class Credentials {
    String email;
    String password;
}