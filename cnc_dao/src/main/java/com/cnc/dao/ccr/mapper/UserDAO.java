package com.cnc.dao.ccr.mapper;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cnc.entity.user.Perms;
import com.cnc.entity.user.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDAO extends BaseMapper<User> {

    void save(User user);

    User findByUserName(String username);


    //根据用户名查询所有角色
    User findRolesByUserName(String username);

    //根据角色id查询权限集合
    List<Perms> findPermsByRoleId(String id);
}
