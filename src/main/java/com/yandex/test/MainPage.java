package com.yandex.test;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private SelenideElement confirmRegion = $(By.xpath("//div[span[contains(@class, 'region-notification__ok')]]"));
    private SelenideElement loginButton = $(By.xpath("//div[@class='header2-nav i-bem header2-nav_js_inited']"));
    private SelenideElement userMenu = $(By.xpath("//div[div[contains(@class, 'user-placeholder')]]"));
    private SelenideElement logoutButton = $(By.xpath("//a[contains(@class, 'logout')]"));
    private SelenideElement computerButton = $(By.xpath("//span[text()='Компьютеры']"));
    private SelenideElement laptopButton = $(By.xpath("//a[text()='Ноутбуки']"));

    public static MainPage open() {
        Selenide.open("/");
        return new MainPage();
    }

    public void logout() {
        //$(confirmRegion).click();
        $(userMenu).click();
        $(logoutButton).click();
    }

    public MainPage computer() {
        $(confirmRegion).click();
        $(computerButton).click();
        return this;
    }

    public MainPage laptop() {
        $(laptopButton).click();
        return new Laptop();
    }


}
