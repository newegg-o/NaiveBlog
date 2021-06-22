package com.xzf.config.component;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Component;

/**
 * @author 呵呵厉害了
 * @date 2021/06/22 14:22
 **/
@Component
public class ShiroUtils {
    public static CustomReturnProfile getProfile() {
        return (CustomReturnProfile) SecurityUtils.getSubject().getPrincipal();
    }
}
