package org.greendog.vulns.jdeser;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;

public class User implements Serializable{
    private int id;
    private String name;

    public User() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {

        this.id = id;
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
