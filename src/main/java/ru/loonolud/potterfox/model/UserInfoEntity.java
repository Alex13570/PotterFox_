package ru.loonolud.potterfox.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.Instant;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoEntity extends BaseEntity {

    private String firstName;

    private String lastName;

    private Instant birthDate;

    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "icon_id")
    private IconInfoEntity iconId;

}
