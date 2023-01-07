package org.pktomojapasja.zwierzeglebackend.domain.pets;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AnnouncementFilter {
    String city;
    String species;
    String sex;
    Integer age;
    String size;
    String color;
}