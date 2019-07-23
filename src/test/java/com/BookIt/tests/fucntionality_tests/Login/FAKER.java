package com.BookIt.tests.fucntionality_tests.Login;
import com.github.javafaker.*;
public class FAKER {



    public static void main(String[] args) {

        Faker faker=new Faker();

        String name=faker.name().firstName();
        System.out.println(name);
    }


}
