package org.pktomojapasja.zwierzeglebackend.domain.pets;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.pktomojapasja.zwierzeglebackend.domain.users.User;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Integer age;
    private String species;
    private String color;
    private String race;
    private String sex;
    private String size;
    private String description;

    @Embedded
    private Traits traits;

    @ManyToOne(cascade = CascadeType.ALL)
    private User owner;

    @Data
    @Embeddable
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Traits {
        private boolean vaccinated;
        private boolean childrenFriendly;
        private boolean trained;
        private boolean aggressive;
        private boolean allergies;
        private boolean sick;
        private boolean acceptsOtherAnimals;
        private boolean disabled;
        private boolean lovesCuddling;
    }
}