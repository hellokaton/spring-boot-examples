package io.github.biezhi.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue
    private long id;
    private String username;
    private String name;
    private int age;
    private double balance;

    public User() {
    }

    public User(String username, String name, int age, double balance) {
        this.username = username;
        this.name = name;
        this.age = age;
        this.balance = balance;
    }

}
