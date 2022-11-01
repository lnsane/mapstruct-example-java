package com.example.mapstructexamplejava.model.convent;

import com.example.mapstructexamplejava.model.dto.UserDTO;
import com.example.mapstructexamplejava.model.params.UserParams;
import com.example.mapstructexamplejava.model.po.User;
import com.example.mapstructexamplejava.model.vo.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

/**
 * @author CunLu Wang
 * @since 2022/10/31
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class UserConvent {


    public abstract UserDTO copyUserDto(UserParams userParams);

    public abstract List<UserDTO> copyListUserDto(List<UserParams> userParams);

    public abstract UserVO copyUserVo(UserDTO userDTO);

    public abstract List<UserVO> copyUserListVo(List<UserDTO> userDTO);

    public abstract User copyUserPo(UserParams userParams);

    public abstract UserVO copyUserVo(User user);

    public abstract User copyUserPo(UserDTO userDTO);
}
