package ru.loonolud.potterfox.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.loonolud.potterfox.model.RefreshToken;
import ru.loonolud.potterfox.model.UserDetailsEntity;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserDetailsEntity, UUID> {

    Optional<UserDetailsEntity> findByEmail(String email);
    Optional<UserDetailsEntity> findByRefreshToken(RefreshToken refreshToken);

}
