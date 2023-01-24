package ru.loonolud.potterfox.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.loonolud.potterfox.model.IconInfoEntity;

import java.util.UUID;

public interface IconInfoRepository extends JpaRepository<IconInfoEntity, UUID> {
}
