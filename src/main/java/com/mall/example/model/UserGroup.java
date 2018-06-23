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
@Table(name="user_group")
public class UserGroup {

    @Id
    @GeneratedValue(generator="id")
    @GenericGenerator(name="id", strategy="native")
    private int id;

    @Column(length = 20)
    private String groupName;

    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updatedAt;

    @ManyToMany(mappedBy = "userGroups")
    private List<User> users = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserGroup userGroup = (UserGroup) o;
        return id == userGroup.id &&
                Objects.equals(groupName, userGroup.groupName) &&
                Objects.equals(createdAt, userGroup.createdAt) &&
                Objects.equals(updatedAt, userGroup.updatedAt) &&
                Objects.equals(users, userGroup.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, groupName, createdAt, updatedAt, users);
    }
}

