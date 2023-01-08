package org.pktomojapasja.zwierzeglebackend.api.pets;

import lombok.Builder;
import lombok.Value;
import org.pktomojapasja.zwierzeglebackend.domain.pets.Announcement;

@Value
@Builder
class ContactDto {
    String phoneNumber;
    String email;
    String city;

    static ContactDto from(Announcement.Contact contact) {
        return ContactDto.builder()
                .city(contact.getCity())
                .phoneNumber(contact.getPhoneNumber())
                .email(contact.getEmail())
                .build();
    }
}