package com.yandex.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Laptop extends MainPage {

    private SelenideElement blackColorButton = $(By.xpath("(//label[@class='_1V4a1pT7KH'])[1]"));
    private SelenideElement whiteColorButton = $(By.xpath("(//label[@class='_1V4a1pT7KH'])[4]"));
    private SelenideElement priceFromButton = $(By.xpath("//input[@id='glpricefrom']"));
    private SelenideElement hpManufacturerButton = $(By.xpath("(//div[@class='LhMupC0dLR'])[6]"));
    private SelenideElement lenovoManufacturerButton = $(By.xpath("(//div[@class='LhMupC0dLR'])[8]"));
    private SelenideElement priceButton = $(By.xpath("(//a[@class='link link_theme_major n-filter-sorter__link i-bem link_js_inited'])[2]"));
    private SelenideElement priceLaptop = $(By.xpath("(//div[@class='price'])[1]"));
    private SelenideElement nameLaptop = $(By.xpath("(//h3[@class='n-snippet-card2__title'])[1]"));

    public static Laptop open() {
        return new Laptop();
    }

    public Laptop filterPanelSearch() {
        $(priceFromButton).click();
        $(priceFromButton).sendKeys("30000");
        $(hpManufacturerButton).click();
        $(lenovoManufacturerButton).click();
        $(blackColorButton).click();
        $(whiteColorButton).click();
        $(priceButton).click();
        return this;
    }

    public Laptop getNameProduct() {
        ;
        String name = $(nameLaptop).getText();
        System.out.println(name);
        return this;
    }

    public Laptop getPriceProduct() {
        String price = $(priceLaptop).getText();
        System.out.println(price);
        return this;
    }


}
