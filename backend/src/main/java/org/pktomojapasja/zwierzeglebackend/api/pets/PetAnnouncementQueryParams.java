package org.pktomojapasja.zwierzeglebackend.api.pets;

import lombok.Builder;
import lombok.Value;
import org.pktomojapasja.zwierzeglebackend.domain.pets.AnnouncementFilter;

@Value
@Builder
class PetAnnouncementQueryParams {
    String city;
    String species;
    String sex;
    Integer age;
    String size;
    String color;

    AnnouncementFilter toAnnouncementFilter() {
        return AnnouncementFilter.builder()
                .age(age)
                .city(city)
                .color(color)
                .sex(sex)
                .size(size)
                .species(species)
                .build();
    }
}