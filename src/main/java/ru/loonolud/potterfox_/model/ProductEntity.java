package ru.loonolud.potterfox_.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity extends BaseEntity {

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private Character[] description;

    @Column(columnDefinition = "decimal(10,2)", nullable = false)
    private Double price;

    @OneToMany
    @JoinColumn
    private Set<IconInfoEntity> icons;

}
