package ru.loonolud.potterfox_.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.loonolud.potterfox_.api.Role;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsEntity extends BaseEntity{

    @Column(columnDefinition="TEXT")
    private Character[] password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userInfoId", referencedColumnName = "Id")
    private UserInfoEntity userInfo;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "token_id")
    private RefreshToken refreshToken;

}
