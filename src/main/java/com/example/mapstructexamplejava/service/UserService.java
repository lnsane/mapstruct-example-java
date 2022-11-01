package com.example.mapstructexamplejava.service;

import com.example.mapstructexamplejava.model.dto.UserDTO;
import com.example.mapstructexamplejava.model.params.UserParams;
import com.example.mapstructexamplejava.model.vo.UserVO;

import java.util.List;

/**
 * @author CunLu Wang
 * @since 2022/10/31
 */
public interface UserService {
    UserVO queryUser(UserDTO userDTO);

    List<UserVO> queryUserList(List<UserDTO> copyListUserDto);

    UserVO saveUser(UserParams userParams);

    UserVO changeUser(Integer id, UserDTO copyUserDto);
}
