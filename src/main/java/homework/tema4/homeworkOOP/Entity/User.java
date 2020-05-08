package homework.tema4.homeworkOOP.Entity;

import homework.tema4.homeworkOOP.repository.UserRepository;

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
