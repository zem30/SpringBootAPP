package ru.zem.springbootapp.springbootapp.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name ="name")
    private String name;

    @Column(name ="lastname")
    private String lastname;

    @Column(name ="age")
    private int age;

    @Column(name ="department")
    private String department;

    public User() {
    }

    public User(String name, String lastname, int age, String department) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.department = department;
    }

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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "User{" + " name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                '}';
    }
}