package homework.tema4.homeworkOOP.service;

import homework.tema4.homeworkOOP.Entity.BankAccount;
import homework.tema4.homeworkOOP.Entity.Card;
import homework.tema4.homeworkOOP.Entity.User;

import java.util.List;

public class BankAccountService {

    private static BankAccount getUserBankAccount(Card card) {
        List<BankAccount> allBankAccounts = User.getAccounts();

        for (BankAccount account : allBankAccounts) {
            List<Card> allAccountCards = account.getAttachedCardNumber();
            for (Card accountCard : allAccountCards) {
                if (accountCard.getCardNumber() == card.getCardNumber()) {
                    return account;
                }
            }
        }

        return null;
    }

    public void addMoney(Card card, long amount) throws Exception {
        if (amount < 0) {
            throw new Exception("Amount should be positive number!");
        }

        BankAccount userBankAccount = getUserBankAccount(card);

        if (userBankAccount != null) {
            long currentBalance = userBankAccount.getBalance();

            currentBalance += amount;

            userBankAccount.setBalance(currentBalance);
        } else {
            throw new Exception("Card was not found in dataBase!");
        }
    }

    public void withdrawMoney(Card card, long amount) throws Exception {
        if (amount < 0) {
            throw new Exception("Amount should be positive number!");
        }

        BankAccount userBankAccount = getUserBankAccount(card);

        if (userBankAccount != null) {
            long currentBalance = userBankAccount.getBalance();

            if (currentBalance < amount) {
                throw new Exception("You do not have enough money in this account!");
            } else {
                currentBalance -= amount;
                userBankAccount.setBalance(currentBalance);
            }
        } else {
            throw new Exception("Card was not found in dataBase!");
        }
    }

    public long getAccountBalance(Card card) throws Exception {

        BankAccount userBankAccount = getUserBankAccount(card);

        if (userBankAccount != null) {
            long currentBalance = userBankAccount.getBalance();

            return currentBalance;
        } else {
            throw new Exception("Card was not found in dataBase!");
        }
    }
}
