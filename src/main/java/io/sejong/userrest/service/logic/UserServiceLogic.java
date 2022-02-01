package io.sejong.userrest.service.logic;

import io.sejong.userrest.entity.User;
import io.sejong.userrest.service.UserService;
import io.sejong.userrest.store.UserStore;
import io.sejong.userrest.store.logic.UserStoreLogic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service    // DOI에 빈으로 등록
@RequiredArgsConstructor    // DOI할 변수에 final 붙이면 생성자로서 DI 주입해줌
public class UserServiceLogic implements UserService {

//   객체 생성을 안해줘도 DI 해줌
    private final UserStore userStore;

    @Override
    public String register(User newUser) {
        return this.userStore.create(newUser);
    }

    @Override
    public void modify(User newUser) {
        this.userStore.update(newUser);

    }

    @Override
    public void remove(String id) {
        this.userStore.delete(id);
    }

    @Override
    public User find(String id) {
        return this.userStore.retrieve(id);
    }

    @Override
    public List<User> findAll() {
        return this.userStore.retrieveAll();
    }
}
