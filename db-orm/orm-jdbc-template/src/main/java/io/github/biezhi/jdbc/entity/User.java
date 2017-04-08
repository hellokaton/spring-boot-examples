package io.github.biezhi.jdbc.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

}
