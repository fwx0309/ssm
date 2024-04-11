package org.fwx.controller;

import org.fwx.service.UserService;

/**
 * Date:2022/7/2
 * Author:ybc
 * Description:
 */
public class UserController {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void saveUser(){
        userService.saveUser();
    }
}
