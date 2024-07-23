package com.aj.springdemo1;

import com.aj.springdemo1.api.controller.ProductController;
import com.aj.springdemo1.api.controller.UserController;
import com.aj.springdemo1.api.model.User;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Springdemo1ApplicationTests {

    @Autowired
    UserController userController;
    @Test
    void getUser() {
//        User user = userController.getUser(1);
//        Assert.(user,"User should exist");
//        Assertions.assertThat(user.getId()).isEqualTo(1);

    }

}
