package com.github.prgrms.socialserver.User.service;

import com.github.prgrms.socialserver.User.model.User;
import com.github.prgrms.socialserver.User.model.UserDTO;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User getUser(long seq);
    long join(UserDTO userDTO);
}
