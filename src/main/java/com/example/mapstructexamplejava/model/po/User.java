package com.example.mapstructexamplejava.model.po;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author CunLu Wang
 * @since 2022/10/31
 */
@Getter
@Setter
public class User {
    /**
     * id
     */
    private Integer id;
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
    private LocalDateTime startTime;


}
