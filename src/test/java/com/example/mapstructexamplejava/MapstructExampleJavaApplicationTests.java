package com.example.mapstructexamplejava;

import com.example.mapstructexamplejava.controller.UserController;
import com.example.mapstructexamplejava.model.test.UserTest;
import com.example.mapstructexamplejava.model.vo.UserVO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Order(value = 2)
@ActiveProfiles("test")
class MapstructExampleJavaApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(value = 3)
    void mockUser() throws Exception {
        UserTest userParams = new UserTest();
        userParams.setUserName("root");
        userParams.setAge(1);
        userParams.setStartTime("2022-12-12 12:12:12");

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletResponse response = this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post(UserController.UserApi.PREFIX + UserController.UserApi.QUERY_USER)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(userParams)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn()
                .getResponse();
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        UserVO userVO = mapper.readValue(response.getContentAsString(), UserVO.class);
        log.info("user vo : {}", new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(userVO));
    }

    @Test
    @Order(value = 2)
    void mockUserList() throws Exception {
        List<UserTest> userList = new ArrayList<>();
        UserTest userParams1 = new UserTest();
        userParams1.setUserName("root");
        userParams1.setAge(1);
        userParams1.setStartTime("2022-12-12 12:12:12");

        UserTest userParams2 = new UserTest();
        userParams2.setUserName("root");
        userParams2.setAge(1);
        userParams2.setStartTime("2022-12-12 12:12:12");
        userList.add(userParams1);
        userList.add(userParams2);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletResponse response = this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post(UserController.UserApi.PREFIX + UserController.UserApi.QUERY_USER_LIST)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(userList)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn()
                .getResponse();
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        List<UserVO> userVOList = mapper.readValue(response.getContentAsString(), new TypeReference<List<UserVO>>(){});
        log.info("userVOList vo : {}", new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(userVOList));
    }

    @Test
    @Order(value = 3)
    void mockInsertUser() throws Exception {
        UserTest userParams1 = new UserTest();
        userParams1.setUserName("root");
        userParams1.setAge(1);
        userParams1.setStartTime("2022-12-12 12:12:12");

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletResponse response = this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post(UserController.UserApi.PREFIX + UserController.UserApi.SAVE_USER)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(userParams1)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn()
                .getResponse();
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        UserVO userVO = mapper.readValue(response.getContentAsString(),UserVO.class);
        log.info("user vo : {}", new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(userVO));
    }


}
