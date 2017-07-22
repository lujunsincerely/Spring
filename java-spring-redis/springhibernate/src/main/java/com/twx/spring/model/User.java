package com.twx.spring.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by twx on 2017/6/27.
 */
@Entity
@Table
public class User implements Serializable {
    private static final long serialVersionUID = 172643386440351811L;
    private int id;
    private String username;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Size(min = 6)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
