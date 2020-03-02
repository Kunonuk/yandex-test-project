package com.yandex.test.ui;

import com.codeborne.selenide.Configuration;
import com.yandex.test.Laptop;
import com.yandex.test.MainPage;
import org.junit.Before;
import org.junit.Test;


public class ProductSearch {

    @Before
    public void setUp() {
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
                .clickOpenCollection()
                .listLaptop();
    }
}

