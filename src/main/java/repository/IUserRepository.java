package repository;

import model.User;

import java.util.List;

public interface IUserRepository<T> {
    List<T> getAllByName(User user);
}
