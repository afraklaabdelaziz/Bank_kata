package com.bank_kata;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        AccountServiceImpl banka = new AccountServiceImpl();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entre your name");
        String name = scanner.nextLine();


        System.out.println("---------------------- Welcome " + name + " ----------------------------------------");

        banka.menu();
    }
}