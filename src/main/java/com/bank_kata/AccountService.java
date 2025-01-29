package com.bank_kata;

public interface AccountService {
    void withdraw(int amount);
    void deposit(int amount);
    void printStatement();
}
