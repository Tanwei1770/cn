package com.cnc.config.deploy;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.cnc.entity.user.User;
import com.cnc.service.ccr.UserService;
import com.cnc.tool.ApplicationContext.ApplicationContextUtils;

import com.cnc.tool.jwt.JWTUtils;
import com.cnc.tool.jwt.JwtToken;
import com.cnc.tool.redisKey.UserKeys;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author 谭炜
 * @create 2020-11-17 11:27
 */
public class MyRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //获取token
        System.out.println(authenticationToken.getCredentials());
        String token = (String) authenticationToken.getCredentials();
        if (token == null) {
            throw new AuthenticationException("token为空!");
        }
        User user = checkUserTokenIsEffect(token);
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, token, getName());

        return simpleAuthenticationInfo;
    }


    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }
    /**
     * 校验token的有效性
     *
     * @param token
     */
    public User checkUserTokenIsEffect(String token) throws AuthenticationException {
        User loginUser;
        UserService userService = (UserService) ApplicationContextUtils.getBean("userService");
        String username = JWTUtils.getUsername(token);
        try {
            JWTUtils.verify(token);
            loginUser = userService.findByUserName(username);
            //检查token
        }catch (TokenExpiredException e) {
            RedisTemplate redisTemplate = (RedisTemplate) ApplicationContextUtils.getBean("redisTemplate");
            boolean isLogin = redisTemplate.opsForHash().hasKey(UserKeys.USER,username);
            System.out.println(isLogin);
            if (isLogin){
                loginUser = userService.findByUserName(username);
                System.out.println("token失效了  ");
//                HashMap<String, String> map = new HashMap<>(1);
//                map.put("username", username);
//                String newToken = JWTUtils.getToken(map);
               // redisTemplate.opsForHash().put("user",username,newToken);
            }else{
                throw new AuthenticationException("无效");
            }

        }
        return loginUser;
    }

}
