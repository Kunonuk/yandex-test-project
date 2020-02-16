package com.yandex.test;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private SelenideElement fieldLogin = $(By.xpath("//input[@id='passp-field-login']"));
    private SelenideElement fieldPassword = $(By.xpath("//input[@id='passp-field-passwd']"));
    private SelenideElement loginButton = $(By.xpath("//div[@class='passp-button passp-sign-in-button']"));

    public static LoginPage open() {
        Selenide.open("/");
        return new LoginPage();
    }

    public MainPage loginAs(String userForTestJava, String userForTestJava1) throws InterruptedException {
        $(fieldLogin).sendKeys(userForTestJava);
        $(loginButton).click();
        $(fieldPassword).sendKeys(userForTestJava1);
        Thread.sleep(2000);
        $(loginButton).click();
        return new MainPage();
    }
}
