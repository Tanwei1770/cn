package com.cnc.controller.ccr;

import com.cnc.entity.homePage.HotIssue;
import com.cnc.entity.homePage.TopLine;
import com.cnc.service.ccr.TopLineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 谭炜
 * @create 2021-01-11 23:24
 */
@Controller
@RequestMapping("topLine")
@ResponseBody
@Api(tags="精选头条接口")
public class TopLineController {

  @Autowired
    TopLineService topLineService;

    @GetMapping("list")
    @ApiOperation("查询精选头条接口")
    public List<TopLine> selectHotIssue() {
        return topLineService.selectTopLineList();
    }
}
