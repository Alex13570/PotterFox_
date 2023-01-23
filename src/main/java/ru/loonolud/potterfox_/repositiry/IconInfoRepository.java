package ru.loonolud.potterfox_.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.loonolud.potterfox_.model.IconInfoEntity;

public interface IconInfoRepository extends JpaRepository<IconInfoEntity, Long> {
}
