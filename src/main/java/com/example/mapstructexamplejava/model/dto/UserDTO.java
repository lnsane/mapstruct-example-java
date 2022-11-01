package com.example.mapstructexamplejava.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author CunLu Wang
 * @since 2022/10/31
 */
@Setter
@Getter
public class UserDTO {
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
