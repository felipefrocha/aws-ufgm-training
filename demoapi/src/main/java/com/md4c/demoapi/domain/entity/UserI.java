package com.md4c.demoapi.domain.entity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Data
@NoArgsConstructor
public class UserI {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String userName;
    private String password;

    public UserI(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
