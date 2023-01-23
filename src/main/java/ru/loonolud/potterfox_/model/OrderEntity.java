package ru.loonolud.potterfox_.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity extends BaseEntity{

    @ManyToOne
    private UserInfoEntity user;

    @OneToMany
    private Set<OrderDetailEntity> orderDetails;

    private String address;

}
