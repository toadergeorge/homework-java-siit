package homework.tema4.homeworkOOP.service;

import homework.tema4.homeworkOOP.Entity.BankAccount;
import homework.tema4.homeworkOOP.Entity.Card;
import homework.tema4.homeworkOOP.Entity.User;

import java.util.List;

public class CardAccountService {

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

    public void changeCardPin(Card card, int newPinNumber) {
        card.setPinNumber(newPinNumber);
    }

    public Card getUserCardByNumberAndPin(long cardNumber, int cardPin) {
        List<BankAccount> allBankAccounts = User.getAccounts();

        for (BankAccount account : allBankAccounts) {
            List<Card> allAccountCards = account.getAttachedCardNumber();
            for (Card accountCard : allAccountCards) {
                if (cardNumber == accountCard.getCardNumber() && cardPin == accountCard.getPinNumber()) {
                    return accountCard;
                }
            }
        }
        return null;
    }
}