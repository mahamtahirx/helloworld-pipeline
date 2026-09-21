package com.helloworld;

import java.util.Scanner;

public class HelloWorld {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String username = sc.hasNextLine() ? sc.nextLine() : "World";
        System.out.println(greet(username));
        sc.close();
    }

    /**
     * Builds the greeting message for the given username.
     * Pulled out of main() so it can be unit tested directly.
     */
    public static String greet(String username) {
        return "Hello World," + username;
    }
}
