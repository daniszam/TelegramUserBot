package model;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class User {
    private String firstName;
    private String lastName;
    private Short age;
    private Date birthday;
    private Boolean gender;
}
