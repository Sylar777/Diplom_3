package com.yandex.diplom3;
import java.util.Random;

public class TestData {
    private String name;
    private String mail;
    private String password;

    public TestData(){
        this.mail = "ds"+ new Random().nextInt(10000) + "@yandex.ru";
        this.password = "123541";
        this.name = "ds";
        System.out.println("mail = " + mail + "password = " + password);
    }

    public String getName(){
        return name;
    }

    public String getMail(){
        return mail;
    }

    public String getPassword(){
        return password;
    }
}
