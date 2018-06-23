package com.mall.example.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(generator="id")
    @GenericGenerator(name="id", strategy="native")
    private int id;

    @Column(length = 255)
    private String username;

    @Column(length = 255)
    private int age;

    @Column(updatable=false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updatedAt;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<UserGroup> userGroups = new ArrayList<>();

    public User() {
    }

    public User(int id, String username, int age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }

    public void addUserGroup(UserGroup userGroup) {
        userGroups.add(userGroup);
        userGroup.getUsers().add(this);
    }

    public void removeUserGroup(UserGroup userGroup) {
        userGroups.remove(userGroup);
        userGroup.getUsers().remove(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<UserGroup> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(List<UserGroup> userGroups) {
        this.userGroups = userGroups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                age == user.age &&
                Objects.equals(username, user.username) &&
                Objects.equals(createdAt, user.createdAt) &&
                Objects.equals(updatedAt, user.updatedAt) &&
                Objects.equals(userGroups, user.userGroups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, age, createdAt, updatedAt, userGroups);
    }
}
