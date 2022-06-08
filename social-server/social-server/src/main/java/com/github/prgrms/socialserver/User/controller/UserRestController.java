package com.github.prgrms.socialserver.User.controller;

import com.github.prgrms.socialserver.CommonResponse;
import com.github.prgrms.socialserver.User.model.UserDTO;
import com.github.prgrms.socialserver.User.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<Object> getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping("/{seq}")
    public ResponseEntity<Object>  getUser(@PathVariable long seq){
        return ResponseEntity.ok().body(userService.getUser(seq));
    }

    @PostMapping("/join")
    public ResponseEntity<Object> join(@RequestBody UserDTO userDTO){
        userService.join(userDTO);
        return ResponseEntity.ok().body(new CommonResponse(true, "가입완료"));
    }

}
