package ru.loonolud.potterfox_.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "files")
public class IconDocument {

    @Id
    private String id;

    private Long size;

    private String fileName;

    private String mimeType;

    private Binary content;

}
