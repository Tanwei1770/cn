package com.cnc.service.ccr.impl;



import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cnc.entity.user.Perms;
import com.cnc.entity.user.User;
import com.cnc.service.ccr.UserService;
import com.cnc.dao.ccr.mapper.UserDAO;

import com.cnc.tool.salt.SaltUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDAO, User> implements UserService {


    @Resource
    private UserDAO userDAO;


    @Override
    public List<Perms> findPermsByRoleId(String id) {
        return userDAO.findPermsByRoleId(id);
    }

    @Override
    public boolean loginUser(String userName, String passWord) {
        User user = findByUserName(userName);
        if (!ObjectUtils.isEmpty(user)) {
            //使用md5 + salt + hash散列
            Md5Hash md5Hash2 = new Md5Hash(passWord, user.getSalt(), 1024);
            String toPassWord = md5Hash2.toHex();
            if (toPassWord.equals(user.getPassword())) {
                return true;
            }
        }

        return false;
    }

    @Override
    public User findRolesByUserName(String username) {
        return userDAO.findRolesByUserName(username);
    }

    @Override
    public User findByUserName(String username) {
        return userDAO.findByUserName(username);
    }

    @Override
    public void register(User user) {
        String salt = SaltUtils.getSalt(8);
        user.setSalt(salt);
        Md5Hash md5Hash = new Md5Hash(user.getPassword(),salt,1024);
        user.setPassword(md5Hash.toHex());
        userDAO.save(user);
    }
}
