package homework.HomeworkOOP.bank.entity;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String iban;
    private long balance;
    private List<Card> attachedCardNumber;

    public BankAccount(String iban){
        this.iban = iban;
        this.attachedCardNumber = new ArrayList<Card>();
    }

    public void addMoney(long amount) throws Exception {
        if(amount < 0){
            throw new Exception("Amount should be positive number!");
        }

        this.balance = this.balance + amount;
    }

    public void withdrawMoney(long amount) throws Exception {
        if(amount < 0){
            throw new Exception("Amount should be positive number!");
        }

        if(this.balance < amount){
            throw new Exception("You do not have enough money in this account!");
        }

        this.balance = this.balance - amount;
    }

    public void attachCard(Card cardNumber) {
        this.attachedCardNumber.add(cardNumber);
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public List<Card> getAttachedCardNumber() {
        return this.attachedCardNumber;
    }
}
