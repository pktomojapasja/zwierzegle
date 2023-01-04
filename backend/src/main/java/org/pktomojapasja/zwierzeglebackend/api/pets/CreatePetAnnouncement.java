package org.pktomojapasja.zwierzeglebackend.api.pets;

import lombok.Value;
import org.pktomojapasja.zwierzeglebackend.domain.pets.Announcement;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Value
class CreatePetAnnouncement {
    Long organizationId;
    Long adoptionFormId;
    Pet pet;
    Traits traits;

    Announcement toAnnouncement(List<MultipartFile> images) {
        return Announcement.builder().build();
    }

    @Value
    static class Pet {
        String name;
        Integer age;
        String species;
        String color;
        String race;
        String sex;
        String size;
        String description;
    }

    @Value
    static class Traits {
        boolean vaccinated;
        boolean childrenFriendly;
        boolean trained;
        boolean aggressive;
        boolean allergies;
        boolean sick;
        boolean acceptsOtherAnimals;
        boolean disabled;
        boolean lovesCuddling;
    }
}