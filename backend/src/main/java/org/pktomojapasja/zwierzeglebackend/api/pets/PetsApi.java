package org.pktomojapasja.zwierzeglebackend.api.pets;

import lombok.RequiredArgsConstructor;
import org.pktomojapasja.zwierzeglebackend.domain.pets.AnnouncementService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/pets")
@RequiredArgsConstructor
public class PetsApi {
    private final AnnouncementService announcementService;

    @PostMapping(path = "/announcements", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Void> createAnnouncement(@RequestPart("images") List<MultipartFile> images, @RequestPart("request") CreatePetAnnouncement createPetAnnouncement) {
        var announcement = announcementService.create(createPetAnnouncement.toAnnouncement(images));
        URI createdAnnouncementUri = URI.create("");
        return ResponseEntity.created(createdAnnouncementUri).build();
    }

}