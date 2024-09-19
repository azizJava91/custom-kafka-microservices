package com.messagebroker.kafkapublisher.service;

import com.messagebroker.kafkapublisher.entity.User;
import com.messagebroker.kafkapublisher.response.RespUser;
import com.messagebroker.kafkapublisher.response.Response;


public interface UserService {


    Response<RespUser> register(User user);
}
