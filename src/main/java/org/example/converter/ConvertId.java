package org.example.converter;

public class ConvertId {
    public static String convertDriverId(int id){
        String a = id + "";
        while (a.length() < 5){
            a = "0" + a;
        }
        return a;
    }
    public static String convertRouteId(int id){
        String a = id + "";
        while (a.length() < 3){
            a = "0" + a;
        }
        return a;
    }
}
