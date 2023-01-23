package ru.loonolud.potterfox_.repositiry;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.loonolud.potterfox_.model.IconDocument;

public interface FileRepository extends MongoRepository<IconDocument, String> {
}
