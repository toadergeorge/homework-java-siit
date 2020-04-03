package homework.Tema4.HomeworkOOP.Entity;

import homework.Tema4.HomeworkOOP.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class User extends UserRepository {

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public void addBankAccount(BankAccount bankAccount) {
        this.bankAccounts.add(bankAccount);
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }
}
