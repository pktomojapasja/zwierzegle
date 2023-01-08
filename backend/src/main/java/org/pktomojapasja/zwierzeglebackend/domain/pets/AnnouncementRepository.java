package org.pktomojapasja.zwierzeglebackend.domain.pets;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {

    @Query("""
            SELECT a FROM Announcement a
            WHERE (:#{#announcementFilter.species} IS NULL OR LOWER(a.pet.species) LIKE LOWER(CONCAT('%', :#{#announcementFilter.species},'%')))
            AND (:#{#announcementFilter.color} IS NULL OR LOWER(a.pet.color) LIKE LOWER(CONCAT('%', :#{#announcementFilter.color},'%')))
            AND (:#{#announcementFilter.sex} IS NULL OR LOWER(a.pet.sex) LIKE LOWER(CONCAT('%', :#{#announcementFilter.sex},'%')))
            AND (:#{#announcementFilter.size} IS NULL OR LOWER(a.pet.size) LIKE LOWER(CONCAT('%', :#{#announcementFilter.size},'%')))
            AND (:#{#announcementFilter.city} IS NULL OR LOWER(a.contact.city) LIKE LOWER(CONCAT('%', :#{#announcementFilter.city},'%')))
            AND (:#{#announcementFilter.age} IS NULL OR a.pet.age = :#{#announcementFilter.age})""")
    Page<Announcement> findAnnouncementsByFilter(@Param("announcementFilter") AnnouncementFilter announcementFilter,
                                                 @Param("pageable") Pageable pageable);
}