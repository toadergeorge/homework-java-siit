package homework.Tema4.HomeworkOOP.Entity;

import homework.Tema4.HomeworkOOP.repository.BankAccountRepository;

import java.util.ArrayList;
import java.util.List;

public class BankAccount extends BankAccountRepository {
    private String iban;
    private long balance;
    private List<Card> attachedCardNumber;

    public BankAccount(String iban){
        this.iban = iban;
        this.attachedCardNumber = new ArrayList<Card>();
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
