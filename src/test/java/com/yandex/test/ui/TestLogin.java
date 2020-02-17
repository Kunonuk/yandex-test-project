package com.yandex.test.ui;

import com.codeborne.selenide.Configuration;
import com.yandex.test.LoginPage;
import com.yandex.test.MainPage;
import org.junit.Before;
import org.junit.Test;

public class TestLogin {

    @Before
    public void setUp() {
        Configuration.baseUrl = "https://passport.yandex.ru/auth?origin=market_desktop_header&retpath=https://market.yandex.ru";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void userCanLoginWithValidCredentional() throws InterruptedException {
        LoginPage.open()
                .loginAs("UserForTestJava", "UserForTestJava1");
    }

    @Test
    public void userCanLogout() {
        MainPage.open()
                .logout();
    }
}
