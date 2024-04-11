package org.fwx.service.impl;

import org.fwx.dao.UserDao;
import org.fwx.service.UserService;

/**
 * Date:2022/7/2
 * Author:ybc
 * Description:
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void saveUser() {
        userDao.saveUser();
    }
}
