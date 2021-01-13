package com.cnc.entity.user;

import com.cnc.tool.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("登录的用户实体")

public class User  extends BaseEntity {
    private String id;
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("用户密码")
    private String password;


    private String salt;

    //定义角色集合
    @ApiModelProperty("用户角色")
    private List<Role> roles;


}
