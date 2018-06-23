package com.mall.example.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Base Controller
 *
 * 因为使用了 struts-rest-plugin 所以不
 * 需要再集成 ActionSupport 只需要创建以
 * Controller 为后缀名的类就可以了
 *
 */
@Controller
@Scope("prototype")
public class BaseController {

}