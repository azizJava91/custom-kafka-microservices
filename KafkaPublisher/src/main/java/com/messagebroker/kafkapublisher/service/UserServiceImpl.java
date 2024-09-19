package com.messagebroker.kafkapublisher.service;

import com.messagebroker.kafkapublisher.entity.User;
import com.messagebroker.kafkapublisher.kafka.PublishService;
import com.messagebroker.kafkapublisher.repository.UserRepository;
import com.messagebroker.kafkapublisher.response.RespUser;
import com.messagebroker.kafkapublisher.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PublishService publishService;

    @Override
    public Response<RespUser> register(User user) {
        Response response = new Response<>();
        User saveUser = User.builder()
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
        RespUser respUser = mapper(user);
        userRepository.save(saveUser);
        publishService.send(user.getEmail());
        response.setT(respUser);
        response.setNotificationText("Testiq maili " + user.getEmail() + " email unvanina gonderildi.");
        return response;
    }

    private RespUser mapper(User user) {
        return RespUser.builder()
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .build();
    }
}
