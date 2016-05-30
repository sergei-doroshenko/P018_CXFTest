package org.sergei.order.test;

/**
 * Created by Sergei_Doroshenko on 4/28/2016.
 */
public class Test01 {
    public static void main(String[] args) {


        String[] strings = new String[]{
                "Hello",
                "HELLO",
                "HeLLo"
        };

        for (String s : strings) {
            System.out.println(s.toLowerCase());
        }
    }
}
