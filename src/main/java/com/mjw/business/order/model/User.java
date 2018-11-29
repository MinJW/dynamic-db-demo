package com.mjw.business.order.model;

/**
 * @Description
 * @Author MinJunWen
 * @Data 2018/11/17 15:35
 * @Version 1.0.0
 **/
public class User {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
