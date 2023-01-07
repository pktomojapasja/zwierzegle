package org.pktomojapasja.zwierzeglebackend.domain.pets;

import lombok.RequiredArgsConstructor;
import org.pktomojapasja.zwierzeglebackend.domain.users.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AnnouncementService {
    private final UserService userService;
    private final AnnouncementRepository announcementRepository;

    @Transactional
    public Announcement create(CreateAnnouncement createAnnouncement) {
        var currentUser = userService.getCurrent();
        var announcement = createAnnouncement.toAnnouncement(currentUser);
        var savedAnnouncement = announcementRepository.save(announcement);
        return savedAnnouncement;
    }

    public Page<Announcement> getByFilter(AnnouncementFilter announcementFilter, int size, int page) {
        var pageable = PageRequest.of(page, size);
        return announcementRepository.findAnnouncementsByFilter(announcementFilter, pageable);
    }

    public Announcement getById(Long id) {
        return announcementRepository.findById(id).orElseThrow();
    }
}