package org.pktomojapasja.zwierzeglebackend.api.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Value;
import org.pktomojapasja.zwierzeglebackend.data.user.User;

@Value
public class RegistrationRequest {
    Registration registration;
    Contact contact;

    public User toUser() {
        return User.builder()
                .email(registration.email)
                .password(registration.password)
                .type(User.Type.valueOf(registration.type.toUpperCase()))
                .build();
    }

    static class Registration {
        @Email
        String email;
        String password;
        @Pattern(regexp = Constraints.TYPE_PATTERN)
        String type;
    }

    static class Contact {
        String name;
        String organizationName;
        String phoneNumber;
        String email;
        String street;
        String buildingNumber;
        String flatNumber;
        String city;
        String zipCode;
    }
}