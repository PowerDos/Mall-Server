package com.mall.model;

import java.util.Date;
import java.util.List;

public class AdminUser {

    private int id;

    private String username;

    private String password;

    private Boolean isAdmin;

    private String email;

    private Date createdAt;

    private Date updatedAt;

    private List<AdminGroup> adminGroups;

}
