package com.github.prgrms.socialserver.User.service;

import com.github.prgrms.socialserver.User.model.User;
import com.github.prgrms.socialserver.User.model.UserDTO;
import com.github.prgrms.socialserver.User.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers(){
        return userRepository.getUsers();
    }

    @Override
    public User getUser(long seq){
        return userRepository.getUser(seq).orElseThrow(() -> new RuntimeException("Failed get User Infomation!"));
    }

    @Override
    public long join(UserDTO userDTO){
        User user = userDTO.getEntity();
        boolean isDuplicated = userRepository.isDuplicated(user.getEmail()).isEmpty() ? false : true;
        if(isDuplicated){
            throw new RuntimeException("Email is Duplicated!");
        }
        return userRepository.join(userDTO);
    }

}
