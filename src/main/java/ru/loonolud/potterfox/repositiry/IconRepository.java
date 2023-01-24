package ru.loonolud.potterfox.repositiry;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.loonolud.potterfox.model.IconEntity;

public interface IconRepository extends MongoRepository<IconEntity, String> {
}
