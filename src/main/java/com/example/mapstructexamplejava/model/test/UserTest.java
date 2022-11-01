package com.example.mapstructexamplejava.model.test;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author CunLu Wang
 * @since 2022/10/31
 */
@Setter
@Getter
public class UserTest {
    /**
     * 用户名
     */
    private String userName;

    /**
     * 年龄
     */
    private Integer age;


    /**
     * 开始时间
     */
    private String startTime;
}
