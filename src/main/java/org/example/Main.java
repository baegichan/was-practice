package org.example;

import java.io.IOException;

//GET /calculate?operand1=
public class Main {
    public static void main(String[] args) throws IOException {
        new CustomWebApp(9081).start();
    }
}