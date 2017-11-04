package com.mesut.beyaztas.cat.facts.utils;

/**
 * Created by Mesut on 04/11/2017.
 */

public class NumberUtils {

    private static final int MAX_COUNT_OF_CAT_FACTS = 312;

    public static int getRandomNumber() {
        return (int) (Math.random() * MAX_COUNT_OF_CAT_FACTS);
    }

}
