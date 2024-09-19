package com.messagebroker.kafkapublisher.controller;

import com.messagebroker.kafkapublisher.entity.User;
import com.messagebroker.kafkapublisher.response.RespUser;
import com.messagebroker.kafkapublisher.response.Response;
import com.messagebroker.kafkapublisher.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public Response<RespUser> register(@RequestBody User user){

        return userService.register(user);
    }
}
