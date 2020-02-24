package com.yandex.test;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Laptop extends MainPage {
    String price;

    private SelenideElement blackColorButton = $(By.xpath("//span[text()='Цвет черный']/.."));
    private SelenideElement whiteColorButton = $(By.xpath("//span[text()='Цвет белый']/.."));
    private SelenideElement priceFromButton = $(By.xpath("//input[@id='glpricefrom']"));
    private SelenideElement hpManufacturerButton = $(By.xpath("//span[text()='HP']/.."));
    private SelenideElement lenovoManufacturerButton = $(By.xpath("//span[text()='Lenovo']/.."));
    private SelenideElement priceButton = $(By.xpath("//a[text()='по цене']"));
    private SelenideElement priceLaptop = $(By.xpath("//div[@class='n-snippet-card2__main-price-wrapper'][1]"));
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
        return this;
    }

    public Laptop getNameProduct() throws InterruptedException {
        Thread.sleep(2000);
        String name = $(nameLaptop).getText();
        System.out.println(name);
        return this;
    }

    public Laptop getPriceProduct() {
        price = $(priceLaptop).getText();
        System.out.println(price + " рублей");
        return this;
    }

    public Laptop filterPriceButtonMinMax() {
        $(priceButton).click();
        return this;
    }

    public Laptop valueCompositionMinMaxPriceLaptop() {
        int value = Integer.parseInt(price);
        int value1 = Integer.parseInt(price);
        int valuMaxMin = value - value1;
        System.out.println(valuMaxMin);
        return this;
    }
}
