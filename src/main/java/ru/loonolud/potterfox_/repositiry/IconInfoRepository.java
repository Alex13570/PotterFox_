package ru.loonolud.potterfox_.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.loonolud.potterfox_.model.IconInfoEntity;

import java.util.UUID;

public interface IconInfoRepository extends JpaRepository<IconInfoEntity, UUID> {
}
