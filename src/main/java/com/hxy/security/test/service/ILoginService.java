package com.hxy.security.test.service;

import com.hxy.security.test.entitys.ResBean;
import com.hxy.security.test.entitys.SysUser;

public interface ILoginService {
    ResBean<String> userLogin(SysUser user);

    ResBean<String> logout();
}
