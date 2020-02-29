package com.yandex.test;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Collection;

import static com.codeborne.selenide.Selenide.$;

public class Laptop extends MainPage {

    private SelenideElement blackColorButton = $(By.xpath("//span[text()='Цвет черный']/.."));
    private SelenideElement whiteColorButton = $(By.xpath("//span[text()='Цвет белый']/.."));
    private SelenideElement priceFromButton = $(By.xpath("//input[@id='glpricefrom']"));
    private SelenideElement hpManufacturerButton = $(By.xpath("//span[text()='HP']/.."));
    private SelenideElement lenovoManufacturerButton = $(By.xpath("//span[text()='Lenovo']/.."));
    private SelenideElement priceButton = $(By.xpath("//a[text()='по цене']"));
    private SelenideElement priceLaptop = $(By.xpath("//div[@class='n-snippet-card2__main-price-wrapper'][1]"));
    private SelenideElement nameLaptop = $(By.xpath("(//h3[@class='n-snippet-card2__title'])[1]"));

    private int parseIntForValueComposition = 0;
    private int minPriceLaptop = 0;
    private int maxPriceLaptop = 0;

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
        String price = $(priceLaptop).getText();
        price = price.replaceAll("\\D", "");
        parseIntForValueComposition = Integer.parseInt(price.trim());
        System.out.println(parseIntForValueComposition + " рублей");

        if (minPriceLaptop == 0){
            minPriceLaptop = parseIntForValueComposition;
        }else
            maxPriceLaptop = parseIntForValueComposition;

        return this;
    }

    public Laptop filterPriceButtonMinMax() {
        $(priceButton).click();
        return this;
    }

    public Laptop valueCompositionMinMaxPriceLaptop() {
        System.out.println(maxPriceLaptop - minPriceLaptop + " рублей разница между самым дешевым и самым дорогим");
        return this;
    }

    public void listLaptop() {
        ArrayList<SelenideElement> lists = new ArrayList<>();
        for(SelenideElement list : lists){
            lists.add(list);
            System.out.println(list);
        }
    }
}
