package com.yandex.test;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private SelenideElement confirmRegion = $(By.xpath("//div[@class='n-region-notification__actions-cell'][1]"));
    private SelenideElement loginButton = $(By.xpath("//div[@class='header2-nav i-bem header2-nav_js_inited']"));
    private SelenideElement userMenu = $(By.xpath("//div[@class='header2-nav i-bem header2-nav_js_inited']"));
    private SelenideElement logoutButton = $(By.xpath("//li[@class='header2-user-menu__item']"));
    private SelenideElement computerButton = $(By.xpath("(//div[@class='_35SYuInI1T _1vnugfYUli'])[4]"));
    private SelenideElement laptopButton = $(By.xpath("//a[text()='Ноутбуки']"));

    public static MainPage open() {
        Selenide.open("https://market.yandex.ru/");
        return new MainPage();
    }

    public void logout() {
        $(confirmRegion).click();
        $(userMenu).click();
        $(logoutButton).click();
    }

    public MainPage computer() {
        $(confirmRegion).click();
        $(computerButton).click();
        return this;
    }

    public MainPage laptop() {
        $(logoutButton).click();
        return new Laptop();
    }


}
