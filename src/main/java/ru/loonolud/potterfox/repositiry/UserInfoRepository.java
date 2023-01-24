package ru.loonolud.potterfox.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.loonolud.potterfox.model.UserInfoEntity;

import java.util.UUID;

public interface UserInfoRepository extends JpaRepository<UserInfoEntity, UUID> {
}
