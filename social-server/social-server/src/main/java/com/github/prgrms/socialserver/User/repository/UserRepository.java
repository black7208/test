package com.github.prgrms.socialserver.User.repository;

import com.github.prgrms.socialserver.User.model.User;
import com.github.prgrms.socialserver.User.model.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> getUsers();
    Optional<User> getUser(long seq);

    Optional<User> isDuplicated(String email);

    long join(UserDTO userDTO);

}
