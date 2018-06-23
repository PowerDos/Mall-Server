package com.mall.example.action;

import com.mall.example.model.User;
import com.mall.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 用户操作-控制层
 *
 */
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    private User user;
    private List<User> users;

    // FIXME: 18-6-23 暂时没有一个可行的方案去掉后缀.json 不加上无法正确返回 json
    // GET /api/v1/user.json
    public void index() {
        this.users = userService.getUsers();
    }

    // GET /api/v1/user/{:id}.json
    public void show() {
        this.user = userService.getUser(0);
    }

    // POST /api/v1/user.json
    public void create() {
        System.out.println("User Create");
    }

    // PUT /api/v1/user/{:id}.json
    public void update() {
        // userService.saveUser(user);
        System.out.println("User Update");
    }

    // DELETE /api/v1/user/{:id}.json
    public void destroy() {
        System.out.println("User Destroy");
    }

    /**
     * 有数据列表的时候就返回数据列表，没有就返回单个实例对象
     *
     * FIXME: 18-6-23 返回的时候会自动生成一个根标签 { data: Object }，暂时没有去掉的解决方案
     *
     * @return Object(List<User> or User)
     */
    public Object getData() {
        return users != null ? users : user;
    }

}