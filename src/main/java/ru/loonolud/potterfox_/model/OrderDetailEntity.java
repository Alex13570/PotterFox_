package ru.loonolud.potterfox_.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn
    private ProductEntity product;

    private Integer count;

}
