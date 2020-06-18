package com.yandex.test;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Laptop extends MainPage {

    private SelenideElement blackColorButton = $(By.xpath("//span[text()='Цвет черный']/.."));
    private SelenideElement whiteColorButton = $(By.xpath("//span[text()='Цвет белый']/.."));
    private SelenideElement priceFromButton = $(By.xpath("//input[@id='glpricefrom']"));
    private SelenideElement hpManufacturerButton = $(By.xpath("//span[text()='HP']/.."));
    private SelenideElement lenovoManufacturerButton = $(By.xpath("//span[text()='Lenovo']/.."));
    private SelenideElement priceButton = $(By.xpath("//a[text()='по цене']"));
    private SelenideElement priceLaptop = $(By.xpath("//div[@class='n-snippet-card2__main-price-wrapper'][1]"));
    private SelenideElement nameLaptop = $(By.xpath("(//h3[@class='n-snippet-card2__title'])[1]"));
    private SelenideElement openLaptopList = $(By.xpath("//a[@class='button button_size_s button_theme_pseudo n-pager__button-next i-bem n-smart-link button_js_inited n-smart-link_js_inited']"));

    private ElementsCollection collectionNameLaptops = $$(By.xpath("(//h3[@class='n-snippet-card2__title'])"));
    private ElementsCollection collectionPriceLaptops = $$(By.xpath("//div[@class = 'price']"));

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

    /*
    Add laptops for collection
    */
    public Laptop listCollectionLaptopArray() {
        ArrayList<String> list = new ArrayList<>();
        for (SelenideElement element : collectionNameLaptops) {
            String nameLaptops = element.getText();
            list.add(nameLaptops);
        }
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

        System.out.println(list.size() + " элементов коллекции");
        return this;
    }

    public Laptop listCollectionLaptopMap() {

        HashMap<ElementsCollection, ElementsCollection> map = new HashMap<>();
        map.put(collectionNameLaptops, collectionPriceLaptops);

        for(Map.Entry<ElementsCollection, ElementsCollection> entry: map.entrySet()){

            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        return this;
    }

    /*public Laptop clickOpenCollection() {
        openLaptopList.click();
        return this;
    }*/
}
