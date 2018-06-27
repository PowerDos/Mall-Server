package com.mall.model;

import org.hibernate.annotations.*;

import javax.persistence.CascadeType;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 后台管理员
 */
@Entity
@Table(name = "admin_user")
public class AdminUser {

    @Id
    @GeneratedValue(generator = "id")
    @GenericGenerator(name = "id", strategy = "native")
    private int id;

    @Column(length=30)
    private String username;

    @Column(length=64)
    private String password;

    @ColumnDefault(value = "false")
    private Boolean isAdmin;

    @Column(length=255)
    private String email;

    @Column(updatable=false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updatedAt;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "admin_users_groups",joinColumns = @JoinColumn(name = "admin_user_id"),inverseJoinColumns = @JoinColumn(name = "admin_group_id"))
    @Fetch(value = FetchMode.SUBSELECT)
    private Set<AdminGroup> adminGroups = new HashSet<>();

    public AdminUser() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Set<AdminGroup> getAdminGroups() {
        return adminGroups;
    }

    public void setAdminGroups(Set<AdminGroup> adminGroups) {
        this.adminGroups = adminGroups;
    }
}
