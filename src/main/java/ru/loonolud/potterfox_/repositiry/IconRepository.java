package ru.loonolud.potterfox_.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.loonolud.potterfox_.model.IconEntity;

public interface IconRepository extends JpaRepository<IconEntity, Long> {
}
