package io.github.biezhi.db;

import javax.persistence.*;

/**
 * Created by biezhi on 2017/3/26.
 */
@Entity
@Table(name = "t_user")
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User [" +
                "id=" + id +
                ", name='" + name + '\'' +
                ']';
    }
}
