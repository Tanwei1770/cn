package com.cnc.controller.ccr;

import com.cnc.entity.homePage.HotIssue;
import com.cnc.service.ccr.HotIssueService;
import com.cnc.tool.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 谭炜
 * @create 2021-01-11 23:04
 */

@Controller
@RequestMapping("hotIssue")
@ResponseBody
@Api(tags="热门话题接口")
public class HotIssueController extends BaseController {

    @Autowired
    private HotIssueService  hotIssueService;
    @GetMapping("list")
    @ApiOperation("查询热话题接口")
    public List<HotIssue> selectHotIssue() {
        return hotIssueService.selectHotIssue();
    }
}
