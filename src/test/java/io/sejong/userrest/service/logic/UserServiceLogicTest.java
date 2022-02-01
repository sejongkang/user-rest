package io.sejong.userrest.service.logic;

import io.sejong.userrest.entity.User;
import io.sejong.userrest.service.UserService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest // 테스트용 어노테이션
public class UserServiceLogicTest
{
    @Autowired
    private UserService userService;

    private User kim;
    private User lee;

    @BeforeEach
    public void startUp(){
        this.kim = new User("Kim","kim@gmail.com");
        this.lee = new User("Lee","lee@gmail.com");
        this.userService.register(this.kim);
        this.userService.register(this.lee);
    }

    @Test
    public void registerTest(){
        User sample = User.sampale();
        assertThat(this.userService.register(sample)).isEqualTo(sample.getId());
        assertThat(this.userService.findAll().size()).isEqualTo(3);
        this.userService.remove(sample.getId());
    }

    @Test
    public void find(){
        assertThat(this.userService.find(lee.getId())).isNotNull();
        assertThat(this.userService.find(lee.getId()).getEmail()).isEqualTo(lee.getEmail());
    }

    @AfterEach
    public void cleanUp(){
        this.userService.remove(kim.getId());
        this.userService.remove(lee.getId());
    }
}
