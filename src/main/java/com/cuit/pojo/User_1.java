package com.cuit.pojo;

public class User_1 {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User_1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
