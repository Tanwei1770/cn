package com.cnc.service.ccr.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cnc.dao.ccr.mapper.HotIssueMapper;
import com.cnc.dao.ccr.mapper.TopLineMapper;
import com.cnc.entity.homePage.HotIssue;
import com.cnc.entity.homePage.TopLine;
import com.cnc.service.ccr.HotIssueService;
import com.cnc.service.ccr.TopLineService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 谭炜
 * @create 2021-01-11 23:21
 */
@Service
public class TopLineServiceImpl extends ServiceImpl<TopLineMapper, TopLine> implements TopLineService {
    @Resource
    private TopLineMapper topLineMapper;
    @Override
    public List<TopLine> selectTopLineList() {
        return topLineMapper.selectList(null);
    }
}
