package ru.loonolud.potterfox.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class IconInfoEntity extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String mongoId;

    private String mimeType;

    private String fileName;

    private Long size;

}
