package com.example.mapstructexamplejava.controller;

import com.example.mapstructexamplejava.model.convent.UserConvent;
import com.example.mapstructexamplejava.model.params.UserParams;
import com.example.mapstructexamplejava.model.vo.UserVO;
import com.example.mapstructexamplejava.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.mapstructexamplejava.controller.UserController.UserApi.PREFIX;

/**
 * @author CunLu Wang
 * @since 2022/10/31
 */
@RestController
@RequestMapping(value = PREFIX)
public class UserController {
    public interface UserApi {
        String PREFIX = "/user";
        String QUERY_USER = "/query";
        String QUERY_USER_LIST = "/query/list";
        String CHANGE_USER = "{id:\\d+}";
        String SAVE_USER = "/save/user";
    }
    @Autowired
    private UserService userService;

    @Autowired
    private UserConvent userConvent;


    @PostMapping(UserApi.QUERY_USER)
    public UserVO queryUser(@RequestBody UserParams userParams) {
       return userService.queryUser(userConvent.copyUserDto(userParams));
    }

    @PutMapping(UserApi.CHANGE_USER)
    public UserVO changeUser(@PathVariable("id") Integer id, @RequestBody UserParams userParams) {
        return userService.changeUser(id,userConvent.copyUserDto(userParams));
    }

    @PostMapping(UserApi.QUERY_USER_LIST)
    public List<UserVO> queryUserList(@RequestBody List<UserParams> userParams) {
        return userService.queryUserList(userConvent.copyListUserDto(userParams));
    }

    @PostMapping(UserApi.SAVE_USER)
    public UserVO saveUser(@RequestBody UserParams userParams) {
        return userService.saveUser(userParams);
    }
}
