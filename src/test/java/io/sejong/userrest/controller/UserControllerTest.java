package io.sejong.userrest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.sejong.userrest.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
//@WebMvcTest // Request 방식 테스트에 사용, 위 어노테이션 사용해도 됨.
class UserControllerTest {

    @Autowired  // Test에서는 Autowired 방식으로 DI 사용.
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void register() throws Exception {
        User sample = User.sampale();
        String content = objectMapper.writeValueAsString(sample);
        mockMvc.perform(post("/users")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk())
                .andExpect(content().string(sample.getId()))
                .andDo(print());
    }

    @Test
    void find() {
    }

    @Test
    void findAll() {
    }

    @Test
    void modify() {
    }

    @Test
    void remove() {
    }
}