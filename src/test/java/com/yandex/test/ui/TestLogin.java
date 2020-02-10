package com.yandex.test.ui;

import com.yandex.test.LoginPage;
import com.yandex.test.MainPage;
import org.junit.Test;

public class TestLogin {

    @Test
    public void userCanLoginWithValidCredentional() {
        LoginPage.open()
                .loginAs("UserForTestJava", "UserForTestJava1");

    }

    @Test
    public void userCanLogout() {
        MainPage.open()
                .logout();
    }
}
