package com.example.mapstructexamplejava.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mapstructexamplejava.model.po.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author CunLu Wang
 * @since 2022/10/31
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
