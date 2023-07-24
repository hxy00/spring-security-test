package com.hxy.security.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hxy.security.test.entitys.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper extends BaseMapper<SysMenu> {
    List<String> selectPermsByUserId(@Param("userid") Long userid);

}
