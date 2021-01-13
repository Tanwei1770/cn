package com.cnc.controller.ccr;



import com.cnc.entity.user.User;
import com.cnc.service.ccr.UserService;

import com.cnc.tool.base.BaseController;
import com.cnc.tool.base.R;
import com.cnc.tool.jwt.JWTUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
@RequestMapping("user")
@ResponseBody
@Api(tags="用户登录接口")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    RedisTemplate redisTemplate;
    /**
     * 验证码方法
     */
//    @RequestMapping("getImage")
//    public void getImage(HttpSession session, HttpServletResponse response) throws IOException {
//        //生成验证码
//        String code = VerifyCodeUtils.generateVerifyCode(4);
//        //验证码放入session
//        session.setAttribute("code",code);
//        //验证码存入图片
//        ServletOutputStream os = response.getOutputStream();
//        response.setContentType("image/png");
//        VerifyCodeUtils.outputImage(220,60,os,code);
//    }

//    /**
//     * 用户注册
//     */
//    @RequestMapping("register")
//    public String register(User user) {
//        try {
//            userService.register(user);
//            return "redirect:/login.jsp";
//        }catch (Exception e){
//            e.printStackTrace();
//            return "redirect:/register.jsp";
//        }
//    }


    /**
     * 退出登录
     */
    @PostMapping("logout")
    @ApiOperation("用户退出接口")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();//退出用户
//        清除Redis中的key
        return "退出成功";
    }

    @PostMapping("test")//假设它是查询单个用户的接口
    public R test(@RequestBody User user) {
        startPage();
        Subject subject = SecurityUtils.getSubject();
        System.out.println(subject.getPrincipal()+"------------------");
        System.out.println(user);
        R r = new R();
        r.put("code",400);
        r.put("data",user);
        return r;
    }


//    @RequestMapping("getImage")
//    public void getImage(HttpSession session, HttpServletResponse response) throws IOException {
//        //生成验证码
//        String code = VerifyCodeUtils.generateVerifyCode(4);
//        //验证码放入session
//        session.setAttribute("code",code);
//        //验证码存入图片
//        ServletOutputStream os = response.getOutputStream();
//        response.setContentType("image/png");
//        VerifyCodeUtils.outputImage(220,60,os,code);
//
//    }
    /**
     * 用来处理身份认证
     *
     * @param username
     * @param password
     * @return
     */
    @PostMapping("login")
    @ApiOperation("用户登录接口")
    public String login(
            @ApiParam("用户名")
                    @RequestParam String username, @ApiParam("用户密码")@RequestParam String password) {
        if (userService.loginUser(username, password)) {

            HashMap<String, String> map = new HashMap<>();
            map.put("username", username);
            String token = JWTUtils.getToken(map);
              redisTemplate.opsForHash().put("user",username,"");

            return "登录成功 token=" + token;
        }
        return "登录失败";
    }
}
