package org.pktomojapasja.zwierzeglebackend.api.pets;

import lombok.Builder;
import lombok.Value;
import org.pktomojapasja.zwierzeglebackend.domain.pets.Pet;

@Value
@Builder
class PetDto {
    String name;
    Integer age;
    String species;
    String color;
    String race;
    String sex;
    String size;
    String description;
    TraitsDto traits;

    Pet toPet() {
        return Pet.builder()
                .traits(traits.toTraits())
                .age(age)
                .color(color)
                .name(name)
                .description(description)
                .race(race)
                .size(size)
                .species(species)
                .sex(sex)
                .build();
    }

    static PetDto from(Pet pet) {
        return PetDto.builder()
                .age(pet.getAge())
                .color(pet.getColor())
                .name(pet.getName())
                .description(pet.getDescription())
                .race(pet.getRace())
                .size(pet.getSize())
                .species(pet.getSpecies())
                .sex(pet.getSex())
                .traits(TraitsDto.from(pet.getTraits()))
                .build();
    }

    @Value
    @Builder
    static class TraitsDto {
        boolean vaccinated;
        boolean childrenFriendly;
        boolean trained;
        boolean aggressive;
        boolean allergies;
        boolean sick;
        boolean acceptsOtherAnimals;
        boolean disabled;
        boolean lovesCuddling;

        Pet.Traits toTraits() {
            return Pet.Traits.builder()
                    .acceptsOtherAnimals(acceptsOtherAnimals)
                    .aggressive(aggressive)
                    .allergies(allergies)
                    .childrenFriendly(childrenFriendly)
                    .disabled(disabled)
                    .lovesCuddling(lovesCuddling)
                    .sick(sick)
                    .trained(trained)
                    .vaccinated(vaccinated)
                    .build();
        }

        static TraitsDto from(Pet.Traits petTraits) {
            return TraitsDto.builder()
                    .acceptsOtherAnimals(petTraits.isAcceptsOtherAnimals())
                    .aggressive(petTraits.isAggressive())
                    .allergies(petTraits.isAllergies())
                    .childrenFriendly(petTraits.isChildrenFriendly())
                    .disabled(petTraits.isDisabled())
                    .lovesCuddling(petTraits.isLovesCuddling())
                    .sick(petTraits.isSick())
                    .trained(petTraits.isTrained())
                    .vaccinated(petTraits.isVaccinated())
                    .build();
        }
    }
}