package com.cnc.tool.jwt;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author 谭炜
 * @create 2020-11-18 11:57
 */
public class JwtToken implements AuthenticationToken{
    private String token;
    private static final long serialVersionUID = 1L;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
