package com.BookIt.tests.fucntionality_tests;

import com.github.javafaker.*;

public class ffff {

    public static void main(String[] args) {


        Faker faker=new Faker();

        String address=faker.address().fullAddress();

        System.out.println(address);



    }
}
