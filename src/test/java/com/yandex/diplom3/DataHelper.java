package com.yandex.diplom3;

public class DataHelper {

    public static String bearerToken(String str){
        String[] list = str.split(",");
        for(String a : list){
            if(a.contains("Bearer")) {
                return a.substring(22, a.length()-1);
            }
        }
        return "";
    }
}
