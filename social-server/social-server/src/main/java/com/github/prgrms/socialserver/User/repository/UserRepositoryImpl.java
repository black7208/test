package com.github.prgrms.socialserver.User.repository;

import com.github.prgrms.socialserver.User.model.User;
import com.github.prgrms.socialserver.User.model.UserDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository{
    private final JdbcTemplate jdbcTemplate;

    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate  = jdbcTemplate;
    }

    @Override
    public List<User> users(){
        return jdbcTemplate.query("SELECT * FROM users", userRowMapper());
    }

    @Override
    public Optional<User> getUser(long seq){
        User user = jdbcTemplate.queryForObject("SELECT * FROM users WHERE seq = ?", userRowMapper(), seq);
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> isDuplicated(String email){
        User user = jdbcTemplate.queryForObject("SELECT * FROM users WHERE email = ?", userRowMapper(), email);
        return Optional.ofNullable(user);
    }

    @Override
    public long join(UserDTO userDTO){
        return jdbcTemplate.update("INSERT INTO users (email, passwd) VALUES (?,?)", userDTO.getPrincipal(), userDTO.getCredentials(), userRowMapper());
    }

    private RowMapper<User> userRowMapper(){
        return (rs, rowNum) -> {
            User.Builder builder = new User.Builder(rs.getLong("seq"), rs.getString("email")
                    , rs.getString("passwd"), rs.getInt("login_count"), rs.getTimestamp("create_at"));

            if (rs.getTimestamp("last_login_at") != null) {
                builder.lastLoginAt(rs.getTimestamp("last_login_at"));
            }
            return builder.build();
        };
    }
}
