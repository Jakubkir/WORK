package com.compsa.liczbapi;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Analiza {
    DecimalFormat df = new DecimalFormat("#.####");
    df.setRoundingMode(RoundingMode.CEILING);
    List<Integer> list = new ArrayList<Integer>();
    list.add(2.920);
    list.add(3.052);
    list.add(3.1336);
    list.add(3.1456);
    list.add(3.1421);
for(Number n : list)

    {
        Double d = n.doubleValue();
        System.out.println(df.format(d));
    }
}
