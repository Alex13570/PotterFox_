package ru.loonolud.potterfox_.repositiry;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.loonolud.potterfox_.model.IconEntity;

public interface IconRepository extends MongoRepository<IconEntity, String> {
}
