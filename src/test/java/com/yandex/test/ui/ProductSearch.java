package com.yandex.test.ui;

import com.yandex.test.MainPage;
import org.junit.Test;

public class ProductSearch {

    @Test
    public void productSearchByFilter() {
        MainPage.open()
                .computer()
                .laptop();
    }
}
