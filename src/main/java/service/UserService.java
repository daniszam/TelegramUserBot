package service;

import model.User;

import java.util.List;

public interface UserService {
    List<User> getUsersByName(String name);
}
