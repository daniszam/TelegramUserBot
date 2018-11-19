package repository;

import model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public class UserRepository implements CrudRepository<User>, IUserRepository<User> {

    private JdbcTemplate jdbcTemplate;

    //language=SQL
    private static final String SQL_SELECT_ALL_USER_BY_NAME =
            "SELECT * FROM telegram_bot_user WHERE first_name=? AND last_name=? ";

    public UserRepository(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    private RowMapper<User> userRowMapper =((resultSet, i) -> User.builder()
            .firstName(resultSet.getString("first_name"))
            .lastName(resultSet.getString("last_name"))
            .birthday(resultSet.getDate("birthday"))
            .gender(resultSet.getBoolean("gender"))
            .build());


    public void add(User model) {

    }

    public User getOneById(Long id) {
        return null;
    }

    public List<User> getAll() {
        return null;
    }

    public void delete(Long id) {

    }

    public List<User> getAllByName(User user) {
        try{
           return jdbcTemplate.query(SQL_SELECT_ALL_USER_BY_NAME,userRowMapper,user.getFirstName(), user.getLastName() );
        }catch (IllegalArgumentException e){
            return null;
        }
    }
}
