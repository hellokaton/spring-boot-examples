package io.github.biezhi.jdbc.service;

import io.github.biezhi.jdbc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(String name) {
        jdbcTemplate.update("insert into `user`(name) values(?)", name);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update("delete from `user` where id = ?", id);
    }

    @Override
    public List<User> getUsers() {
        return jdbcTemplate.query("select * from `user`", new UserMapper());
    }

    @Override
    public User getById(Integer id) {
        return jdbcTemplate.queryForObject("select * from `user` where id = ?", new Object[]{id}, new UserMapper());
    }

    class UserMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            return user;
        }
    }

}
