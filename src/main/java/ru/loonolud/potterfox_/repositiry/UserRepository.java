package ru.loonolud.potterfox_.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.loonolud.potterfox_.model.UserDetailsEntity;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserDetailsEntity, UUID> {
    Optional<UserDetailsEntity> findByEmail(String email);
}
