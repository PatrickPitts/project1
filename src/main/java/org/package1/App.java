package org.package1;

import java.util.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        Scanner k = new Scanner(System.in);

        System.out.println("Welcome to the MyVector demo");


        double[] d1 = new double[]{1.0, 2.0, 3.0};
        double[] d2 = new double[]{1.0, 2.0, 4.0};


        MyVector V1 = new MyVector(d1);
        MyVector V2 = new MyVector(d2);

        System.out.println(V1.get(4));


    }
}
