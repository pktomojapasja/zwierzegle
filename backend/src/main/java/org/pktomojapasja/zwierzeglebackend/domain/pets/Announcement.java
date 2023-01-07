package org.pktomojapasja.zwierzeglebackend.domain.pets;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Embedded
    private Contact contact;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pet_id", referencedColumnName = "id")
    private Pet pet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "announcement")
    private Set<AnnouncementImage> images;

    @Builder
    @Data
    @Embeddable
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Contact {
        private String phoneNumber;
        private String email;
        private String city;
    }
}