package com.cnc.service.ccr;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cnc.entity.homePage.HotIssue;

import java.util.List;

/**
 * @author 谭炜
 * @create 2021-01-11 22:58
 */
public interface HotIssueService  extends IService<HotIssue> {


    /**
     *  查询热卖话题
     * @return
     */
    List<HotIssue> selectHotIssue();
}
