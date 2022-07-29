package ch.luca.cubeslide.coinsapi.util;

import java.text.DecimalFormat;

public class Util {

    public static String coinsAsString(long coins) {
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(coins).replace(",", "'");
    }

}