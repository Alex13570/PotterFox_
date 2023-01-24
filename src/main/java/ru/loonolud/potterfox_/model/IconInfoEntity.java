package ru.loonolud.potterfox_.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
