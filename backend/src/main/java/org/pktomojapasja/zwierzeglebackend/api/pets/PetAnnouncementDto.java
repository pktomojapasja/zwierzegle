package org.pktomojapasja.zwierzeglebackend.api.pets;

import lombok.Builder;
import lombok.Value;
import org.pktomojapasja.zwierzeglebackend.domain.pets.Announcement;
import org.pktomojapasja.zwierzeglebackend.domain.pets.AnnouncementImage;

import java.util.List;

@Value
@Builder
class PetAnnouncementDto {
    PetDto pet;
    ContactDto contact;
    List<byte[]> images;

    static PetAnnouncementDto fromAnnouncement(Announcement announcement) {
        return PetAnnouncementDto.builder()
                .pet(PetDto.from(announcement.getPet()))
                .contact(ContactDto.from(announcement.getContact()))
                .images(announcement.getImages().stream().map(AnnouncementImage::getContent).toList())
                .build();
    }
}