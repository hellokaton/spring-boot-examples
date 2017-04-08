package io.github.biezhi.db;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by biezhi on 2017/3/26.
 */
@Entity
@Table(name = "t_user")
@Data
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 5)
    private String name;

    public User() {

    }

    public User(String name) {
        this.name = name;
    }
}
