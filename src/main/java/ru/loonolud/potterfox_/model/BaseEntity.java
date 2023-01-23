package ru.loonolud.potterfox_.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {
    @Id
    @Column(nullable = false, name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private Instant createDate;

    @UpdateTimestamp
    private Instant updateDate;


}
