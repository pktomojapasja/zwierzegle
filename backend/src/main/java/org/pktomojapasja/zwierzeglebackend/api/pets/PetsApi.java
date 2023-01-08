package org.pktomojapasja.zwierzeglebackend.api.pets;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.pktomojapasja.zwierzeglebackend.domain.pets.AnnouncementService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/pets")
@RequiredArgsConstructor
@SecurityRequirement(name = "auth")
public class PetsApi {
    private final AnnouncementService announcementService;

    @PostMapping(path = "/announcements", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Void> createAnnouncement(@RequestPart(name = "images", required = false) List<MultipartFile> images,
                                                   @RequestPart(name = "request") CreatePetAnnouncement createPetAnnouncement) {
        var announcement = announcementService.create(createPetAnnouncement.toCreateAnnouncement(images));
        URI createdAnnouncementUri = URI.create("/api/pets/announcements/" + announcement.getId());
        return ResponseEntity.created(createdAnnouncementUri).build();
    }

    @GetMapping("/announcements")
    public PetAnnouncements getAnnouncements(@ParameterObject PetAnnouncementQueryParams petAnnouncementQueryParams,
                                             @RequestParam(name = "pageSize", defaultValue = "10") int size,
                                             @RequestParam(name = "page", defaultValue = "0") int page) {
        var announcements = announcementService.getByFilter(petAnnouncementQueryParams.toAnnouncementFilter(), size, page);
        return PetAnnouncements.from(announcements);
    }

    @GetMapping("/announcements/{id}")
    public PetAnnouncementDto getAnnouncements(@PathVariable Long id) {
        var announcement = announcementService.getById(id);
        return PetAnnouncementDto.fromAnnouncement(announcement);
    }

}