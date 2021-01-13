package com.cnc.service.ccr.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cnc.dao.ccr.mapper.HotIssueMapper;
import com.cnc.entity.homePage.HotIssue;
import com.cnc.service.ccr.HotIssueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 谭炜
 * @create 2021-01-11 22:58
 */
@Service
public class HotIssueServiceImpl extends ServiceImpl<HotIssueMapper, HotIssue> implements HotIssueService {
    @Resource
    private HotIssueMapper hotIssueMapper;
    @Override
    public List<HotIssue> selectHotIssue() {
        return hotIssueMapper.selectList(null);
    }
}
