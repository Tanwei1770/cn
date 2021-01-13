package com.cnc.service.ccr;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cnc.entity.homePage.TopLine;
import com.cnc.entity.user.User;

import java.util.List;

/**
 * @author 谭炜
 * @create 2021-01-11 23:21
 */
public interface TopLineService  extends IService<TopLine> {

    /**
     * 查询精选头条
     * @return
     */
    public List<TopLine> selectTopLineList();
}
