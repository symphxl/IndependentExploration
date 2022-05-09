package com.hxl.hutooldemo.entity;

/**
 * Created with IntelliJ IDEA
 *
 * @author haoxiliang
 * @since 2022-05-05 9:44
 */
public class User {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }
}
