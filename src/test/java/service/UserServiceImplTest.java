package service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import repository.UserRepository;

import static org.junit.Assert.*;

public class UserServiceImplTest {

    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "dREAM1cACAO";
    private static final String URL = "jdbc:postgresql://localhost:5432/telegram_user_bot";

    UserService userService;



    @Before
    public void setUp() throws Exception {
        userService = new UserServiceImpl();
    }

    @Test
    public void getUsersByName() {
        String name = "Danis Zamaliev";
        System.out.println(userService.getUsersByName(name));
    }
}