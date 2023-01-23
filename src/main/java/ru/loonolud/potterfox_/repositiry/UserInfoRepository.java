package ru.loonolud.potterfox_.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.loonolud.potterfox_.model.UserInfoEntity;

import java.util.UUID;

public interface UserInfoRepository extends JpaRepository<UserInfoEntity, UUID> {
}
