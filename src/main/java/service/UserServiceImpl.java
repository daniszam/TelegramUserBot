package service;

import model.User;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import repository.UserRepository;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserServiceImpl implements UserService {

    private static final String PASSWORD="PASSWORD";
    private static final String USERNAME = "postgres";
    private static final String LINk = "jdbc:postgresql://localhost:5432/telegram_user_bot";

    private UserRepository userRepository;


    public UserServiceImpl() {
        DriverManagerDataSource dataSource =
                new DriverManagerDataSource();

        dataSource.setUrl(LINk);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);

        this.userRepository = new UserRepository(dataSource);

    }

    public List<User> getUsersByName(String name) {
        Pattern pattern = Pattern.compile("^[\\p{L} .'-]+$");
        Matcher matcher = pattern.matcher(name);
        if (matcher.find()) {
            String user = matcher.group();
            String[] lastAndForName = user.split(" ");
            if (lastAndForName.length > 1) {
                List<User> userList = userRepository.getAllByName(User.builder()
                        .firstName(lastAndForName[0])
                        .lastName(lastAndForName[1])
                        .build());
                return userList;
            }
        }
        return null;
    }
}
