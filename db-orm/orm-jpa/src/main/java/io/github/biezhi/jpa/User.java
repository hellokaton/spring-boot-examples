package io.github.biezhi.jpa;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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

    private String name;

    public User() {

    }

    public User(String name) {
        this.name = name;
    }
}
