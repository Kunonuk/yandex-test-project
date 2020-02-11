package com.yandex.test;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private SelenideElement confirmRegion = $(By.xpath("//div[@class='n-region-notification__actions-cell'][1]"));
    private SelenideElement loginButton = $(By.xpath("//div[@class='header2-nav i-bem header2-nav_js_inited']"));
    private SelenideElement userMenu = $(By.xpath("//span[@class='user__icon user__icon_loaded_yes']"));
    private SelenideElement logoutButton = $(By.xpath("//a[@class='link user user__logout i-bem user_js_inited link_js_inited']"));

    public static MainPage open() {
        Selenide.open("https://market.yandex.ru/");
        return new MainPage();
    }

    public void logout() {
        $(confirmRegion).click();
        $(userMenu).click();
        $(logoutButton).click();
    }
}
