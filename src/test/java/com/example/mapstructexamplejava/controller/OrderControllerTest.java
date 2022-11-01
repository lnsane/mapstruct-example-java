package com.example.mapstructexamplejava.controller;

import com.example.mapstructexamplejava.model.test.OrderTest;
import com.example.mapstructexamplejava.model.vo.OrderVO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
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
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Map;


@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Order(value = 1)
@ActiveProfiles("test")
class OrderControllerTest {
    @Autowired
    private MockMvc mockMvc;


    public OrderTest getOne(){
        OrderTest orderTest = new OrderTest();
        orderTest.setOrderNumber("12937898174987");
        orderTest.setOrderStatus(1);
        orderTest.setOrderTime("2022-12-12 12:12:12");
        orderTest.setIsClose(Boolean.FALSE);
        orderTest.setPrice("12.1123");
        return orderTest;
    }

    @Test
    @Order(value = 3)
    void testQueryOrder() throws Exception {
        OrderTest orderTest = this.getOne();
        ObjectMapper objectMapper = new ObjectMapper();
        MultiValueMap<String, String> valueMap = new LinkedMultiValueMap<>();
        Map<String, String> fieldMap = objectMapper.convertValue(orderTest, new TypeReference<Map<String, String>>() {});
        valueMap.setAll(fieldMap);
        MockHttpServletResponse response = this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get(OrderController.OrderApi.PREFIX + OrderController.OrderApi.QUERY_ORDER)
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .params(valueMap))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn()
                .getResponse();
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        OrderVO orderVO = mapper.readValue(response.getContentAsString(), OrderVO.class);
        log.info("order vo : {}", new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(orderVO));
        Assertions.assertEquals(new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(orderVO),
                new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(orderTest));
    }

    @Test
    @Order(value = 5)
    void testUpdateOrder() throws Exception {

    }


    @Test
    @Order(value = 2)
    void testInsertOrder() throws Exception {
        OrderTest orderTest = this.getOne();
        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletResponse response = this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post(OrderController.OrderApi.PREFIX + OrderController.OrderApi.SAVE_ORDER)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(orderTest)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn()
                .getResponse();
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        OrderVO orderVO = mapper.readValue(response.getContentAsString(), OrderVO.class);
        log.info("order vo : {}", new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(orderVO));
    }
}