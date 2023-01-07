package org.pktomojapasja.zwierzeglebackend.api.pets;

import lombok.Value;
import org.pktomojapasja.zwierzeglebackend.domain.pets.Announcement;
import org.pktomojapasja.zwierzeglebackend.domain.pets.AnnouncementImage;
import org.pktomojapasja.zwierzeglebackend.domain.pets.CreateAnnouncement;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Value
class CreatePetAnnouncement {
    Long adoptionFormId;
    ContactDto contact;
    PetDto pet;

    CreateAnnouncement toCreateAnnouncement(List<MultipartFile> images) {

        var announcementImages = images != null ? images.stream().map(uploadedImage -> {
            try {
                return AnnouncementImage.builder().content(uploadedImage.getBytes()).build();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toSet()) : null;

        return CreateAnnouncement.builder()
                .contact(Announcement.Contact.builder()
                        .city(contact.getCity())
                        .phoneNumber(contact.getPhoneNumber())
                        .email(contact.getEmail())
                        .build())
                .images(announcementImages)
                .pet(pet.toPet())
                .build();
    }
}