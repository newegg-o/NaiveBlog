package com.xzf.config.component;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * jwtToken
 *
 * @author 呵呵厉害了
 * @date 2021/06/21 15:41
 **/
public class JwtToken implements AuthenticationToken {
    private String token;

    public JwtToken(String token){
        this.token=token;
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
