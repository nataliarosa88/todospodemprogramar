package br.com.todospodemprogramar.app.mock;

import br.com.todospodemprogramar.app.model.User;

import java.util.Arrays;
import java.util.List;

public class UserData {

    public static final String USERNAME = "soandso";
    public static final String NAME = "so and so";
    public static final String HOBBY = "my hobbies";
    public static final String EXPERIENCE = "so-and-so";
    public static final String CONTACT = "so";
    public static final String PASSWORD = "mysecret";


    public static User getUserMock() {

        User user = new User();
        user.setName(NAME);
        user.setUsername(USERNAME);
        user.setPassword(PASSWORD);
        user.setExperience(EXPERIENCE);
        user.setContact("so");
        user.setHobby(HOBBY);

        return user;
    }

    public static User getUserMock(int id) {

        User user = new User();
        user.setId(id);
        user.setName(NAME);
        user.setUsername(USERNAME);
        user.setPassword(PASSWORD);
        user.setExperience(EXPERIENCE);
        user.setContact("so");
        user.setHobby(HOBBY);

        return user;
    }

    public static List<User> getUserListMock() {
        return Arrays.asList(getUserMock(), getUserMock(), getUserMock());
    }

    public static List<User> getUserListMock(int id) {
        int i = 1;
        return Arrays.asList(getUserMock(id + i++), getUserMock(id + i++), getUserMock(id + i++));
    }
}