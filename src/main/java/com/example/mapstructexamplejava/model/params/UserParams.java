package com.example.mapstructexamplejava.model.params;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author CunLu Wang
 * @since 2022/10/31
 */
@Setter
@Getter
public class UserParams {
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;
}
