package com.aj.springdemo1;

import com.aj.springdemo1.api.controller.UserController;
import com.aj.springdemo1.api.model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerHttpReqTest {

    @Autowired
    UserController userController;

    @LocalServerPort
    private int port;





    @Test
    void getUser() {
        User user = userController.getUser(1);
//        Assert.(user,"User should exist");
        Assertions.assertThat(user.getId()).isEqualTo(1);

    }

}
