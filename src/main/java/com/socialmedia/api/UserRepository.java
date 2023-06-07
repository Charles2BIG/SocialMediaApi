package com.socialmedia.api;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public class UserRepository implements IUserRepository {

    private static final String SQL_GET_USER_BY_ID =
            "select id, name, email from \"Users\" where id = :id";
    private static final String SQL_INSERT_USER =
            "insert into \"Users\" (name, email, password) values (:userName, :userEmail, :password)";

    private final UserMapper userMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public UserRepository(
            UserMapper userMapper,
            NamedParameterJdbcTemplate jdbcTemplate
    ) {
        this.userMapper = userMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<User> getUserById(int userId) {
        var params = new MapSqlParameterSource();
        params.addValue("id", userId);
        return jdbcTemplate.query(
                SQL_GET_USER_BY_ID,
                params,
                userMapper
        ).stream().findFirst();
    }

    public void insertUser(String userName, String userEmail, String password) {
        var params = new MapSqlParameterSource();
        params.addValue("userName", userName);
        params.addValue("userEmail", userEmail);
        params.addValue("password", password);
        jdbcTemplate.update(SQL_INSERT_USER, params);
    }
}
