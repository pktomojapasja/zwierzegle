package org.pktomojapasja.zwierzeglebackend.data.repository;
import org.pktomojapasja.zwierzeglebackend.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepo extends JpaRepository<User, Long> {
    public Optional<User> findByEmail(String email);
}
