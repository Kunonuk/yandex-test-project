package com.yandex.test.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.yandex.config.ConfigCapability;
import com.yandex.test.LoginPage;
import com.yandex.test.MainPage;
import org.junit.Before;
import org.junit.Test;

public class TestLogin {

    @Before
    public void setUp() {
        Configuration.browser = "com.yandex.config.ConfigCapability";
        Configuration.baseUrl = "https://passport.yandex.ru/auth?origin=market_desktop_header&retpath=https://market.yandex.ru";
        Configuration.holdBrowserOpen = true;

    }

    @Test
    public void userCanLoginWithValidCredentional() throws InterruptedException {
        LoginPage.open()
                .loginAs("UserForTestJava", "UserForTestJava1");
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    @Test
    public void userCanLogout() {
        MainPage.open()
                .logout();
    }
}
