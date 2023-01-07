package org.pktomojapasja.zwierzeglebackend.domain.pets;

import lombok.Builder;
import lombok.Getter;
import org.pktomojapasja.zwierzeglebackend.domain.users.User;

import java.util.Set;

@Builder
@Getter
public class CreateAnnouncement {
    private Announcement.Contact contact;
    private Pet pet;
    private Set<AnnouncementImage> images;

    Announcement toAnnouncement(User user) {
        pet.setOwner(user);
        return Announcement.builder()
                .pet(pet)
                .images(images)
                .contact(contact)
                .build();
    }
}