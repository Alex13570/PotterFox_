package ru.loonolud.potterfox_.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailEntity extends BaseEntity{

    @ManyToOne
    private ProductEntity product;

    private Integer count;

}
