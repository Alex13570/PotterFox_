package ru.loonolud.potterfox_.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class IconEntity extends BaseEntity{

    @Column(unique = true, nullable = false)
    private String mongoId;

    private String mimeType;

    private String fileName;

    @ManyToOne
    @JoinColumn(name="userEmail", nullable=false,referencedColumnName = "email")
    private UserDetailsEntity userEmail;

    private Long size;

}
