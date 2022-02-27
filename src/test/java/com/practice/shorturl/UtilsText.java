package com.practice.shorturl;

import com.practice.shorturl.utils.Utils;

import org.junit.jupiter.api.Test;

public class UtilsText {

    @Test
    public void generateShortUrlTest() {
        String test = Utils.generateShortUrl(4);
        System.out.println(test);
    }
}
