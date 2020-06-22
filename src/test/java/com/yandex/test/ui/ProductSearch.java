package com.yandex.test.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.yandex.config.ConfigCapability;
import com.yandex.test.Laptop;
import com.yandex.test.MainPage;
import org.junit.Before;
import org.junit.Test;


public class ProductSearch {

    @Before
    public void setUp() {
        WebDriverRunner.setWebDriver(ConfigCapability.getChromeOptions());
        Configuration.baseUrl = "https://market.yandex.ru";
        Configuration.holdBrowserOpen = true;

        MainPage.open()
                .computer()
                .laptop();
    }

    @Test
    public void productSearchByFilter() throws InterruptedException {
        Laptop.open()
                .filterPanelSearch()
                .filterPriceButtonMinMax()
                .getNameProduct()
                .getPriceProduct()
                .filterPriceButtonMinMax()
                .getNameProduct()
                .getPriceProduct()
                .valueCompositionMinMaxPriceLaptop()
                //.clickOpenCollection()
                .listCollectionLaptopArray();
                //.listCollectionLaptopMap();
    }
}

