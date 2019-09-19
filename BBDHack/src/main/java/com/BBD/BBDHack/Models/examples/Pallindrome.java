package com.BBD.BBDHack.Models.examples;

public class Pallindrome {

    public static void main(String[] args) {
        String a = "racecar", b = "";

        int n = a.length();

        for(int i = n - 1; i >= 0; i--)  b = b + a.charAt(i);

        if(a.equalsIgnoreCase(b))  System.out.println("The string is palindrome.");

        else  System.out.println("The string is not palindrome.");
    }
}
