package org.pktomojapasja.zwierzeglebackend.api.pets;

import lombok.Value;
import org.pktomojapasja.zwierzeglebackend.domain.pets.Announcement;
import org.springframework.data.domain.Page;

import java.util.List;

@Value
public class PetAnnouncements {
    List<PetAnnouncementDto> announcements;
    int size;
    int page;
    long count;

    static PetAnnouncements from(Page<Announcement> announcements) {
        return new PetAnnouncements(
                announcements.map(PetAnnouncementDto::fromAnnouncement).toList(),
                announcements.getSize(),
                announcements.getNumber(),
                announcements.getTotalElements()
        );
    }
}