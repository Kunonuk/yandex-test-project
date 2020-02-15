package com.yandex.test.ui;

import com.codeborne.selenide.Configuration;
import com.yandex.test.MainPage;
import org.junit.Before;
import org.junit.Test;

public class ProductSearch {

    @Before
    public void setUp() throws Exception {
        Configuration.baseUrl = "https://market.yandex.ru";
    }

    @Test
    public void productSearchByFilter() {
        MainPage.open()
                .computer()
                .laptop();
    }
}
