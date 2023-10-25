package com.david.spring_angular.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Role extends AbstractEntity {

    private String name;

    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;
}