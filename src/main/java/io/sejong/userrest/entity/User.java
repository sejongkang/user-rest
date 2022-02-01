package io.sejong.userrest.entity;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Setter
@Getter
@ToString
public class User {

    private String id;
    private String email;
    private String name;

    public User(){
        this.id = UUID.randomUUID().toString();
    }
    public User(String name, String email){
        this();
        this.name = name;
        this.email = email;
    }
    public static User sampale(){
        return new User("Park", "park@gmail.com");
    }
    public static void main(String[] args){
        User user = new User("Kim","kim@gmail.com");
        System.out.println(new Gson().toJson(user));
    }
}
