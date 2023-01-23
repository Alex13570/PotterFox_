package ru.loonolud.potterfox_.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoEntity extends BaseEntity{

    private String firstName;

    private String lastName;

    private Instant birthDate;

    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "icon_id", referencedColumnName = "mongoId")
    private IconEntity iconId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "details_id", referencedColumnName = "id")
    private UserDetailsEntity detailsId;

}
