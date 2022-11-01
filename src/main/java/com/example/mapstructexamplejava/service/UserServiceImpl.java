package com.example.mapstructexamplejava.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.mapstructexamplejava.mapper.UserMapper;
import com.example.mapstructexamplejava.model.convent.UserConvent;
import com.example.mapstructexamplejava.model.dto.UserDTO;
import com.example.mapstructexamplejava.model.params.UserParams;
import com.example.mapstructexamplejava.model.po.User;
import com.example.mapstructexamplejava.model.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CunLu Wang
 * @since 2022/10/31
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserConvent userConvent;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserVO queryUser(UserDTO userDTO) {
        return userConvent.copyUserVo(userDTO);
    }

    @Override
    public List<UserVO> queryUserList(List<UserDTO> copyListUserDto) {
        return userConvent.copyUserListVo(copyListUserDto);
    }

    @Override
    public UserVO saveUser(UserParams userParams) {
        User user = userConvent.copyUserPo(userParams);
        userMapper.insert(user);
        return userConvent.copyUserVo(user);
    }

    @Override
    public UserVO changeUser(Integer id, UserDTO copyUserDto) {
        userMapper.update(userConvent.copyUserPo(copyUserDto), Wrappers.<User>lambdaUpdate().eq(User::getId,id));
        return userConvent.copyUserVo(copyUserDto);
    }
}
