package com.bank_kata;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class AccountServiceImpl implements AccountService{

    ArrayList<Account> statements = new ArrayList();

    @Override
    public void withdraw(int amount) {
        Account account = new Account();

        if (statements.size() == 0){
            System.out.println("your balance is insufficient");
            menu();
        }else {
            if (amount > statements.get(statements.size()-1).balance){
                System.out.println("your balance is insufficient");
                menu();
            }else {
                account.balance = statements.get(statements.size()-1).balance-amount;
            }
        }
        account.date = LocalDateTime.now();
        account.amountOfOperation = amount;
        account.statementName = "withdraw";
        statements.add(account);
        System.out.println("------------------------------- your statement is success -------------------------------------");
    }

    @Override
    public void deposit(int amount) {
        Account account = new Account();
        int balance = 0;
        if (statements.size() == 0){
            account.balance = amount;
        }else {
            account.balance = statements.get(statements.size()-1).balance+amount;
        }

        account.date = LocalDateTime.now();
        account.amountOfOperation = amount;
        account.statementName = "deposit";
        statements.add(account);
        System.out.println("------------------------------- your statement is success -------------------------------------");
    }

    @Override
    public void printStatement() {
        String operationAfiche = "";
       for (Account statement : statements){
           operationAfiche+= statement.date;
           operationAfiche+= " || ";
           if (statement.statementName.equals("deposit")){
               operationAfiche+= statement.amountOfOperation;
           }else if(statement.statementName.equals("withdraw")){
               operationAfiche+= "-"+statement.amountOfOperation;
           }
           operationAfiche+= " || ";
           operationAfiche+= statement.balance;
           operationAfiche+= "\n";
       }
       System.out.println(operationAfiche);
    }


    void menu (){
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("------------------------------- Choose Statement -------------------------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("1- deposit\n" +
                "2- withdraw\n" +
                "3- print statement\n" +
                "4- press any touch t exit");

        String  choix = scanner.next();

        switch (choix){
            case "1" :
                System.out.println("entre deposit amount");
                int amountDeposit = scanner.nextInt();
                this.deposit(amountDeposit);
                this.menu();
                break;
            case "2" :
                System.out.println("entre withdraw amount");
                int amountWithdraw = scanner.nextInt();
                this.withdraw(amountWithdraw);
                this.menu();
                break;
            case "3" :
                this.printStatement();
                this.menu();
                break;
            default:
                System.out.println("thank you for your visit");

        }
    }
}




