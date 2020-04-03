package homework.Tema4.HomeworkOOP.repository;


import homework.Tema4.HomeworkOOP.Entity.BankAccount;
import homework.Tema4.HomeworkOOP.Entity.Card;
import homework.Tema4.HomeworkOOP.Entity.User;

import java.util.ArrayList;
import java.util.List;

public abstract class UserRepository {

    public final static List<Card> cards = new ArrayList<>();
    public final static List<BankAccount> bankAccounts = new ArrayList<>();

    static {

        BankAccount account1 = new BankAccount("RO2344444444");
        Card card1 = new Card(112233442, 1133344455567L, "john Doe", 2233);
        Card card2 = new Card(552733442, 5533344455567L, "john Doe Son",2233);
        Card card3 = new Card(992233442, 9933344455567L, "john Doe Daughter",2233);

        cards.add(card1);
        cards.add(card2);
        cards.add(card3);

        account1.attachCard(card1);
        account1.attachCard(card2);
        account1.attachCard(card3);
        bankAccounts.add(account1);

        BankAccount account2 = new BankAccount("RO9944444444");
        Card card11 = new Card(772233442, 1133344455567L, "john Doe Mother", 2233);
        Card card22 = new Card(662733442, 5533344455567L, "john Doe Father", 2233);
        Card card33 = new Card(882233442, 9933344455567L, "john Doe Dog", 2233);

        cards.add(card11);
        cards.add(card22);
        cards.add(card33);

        account2.attachCard(card11);
        account2.attachCard(card22);
        account2.attachCard(card33);
        bankAccounts.add(account2);
    }

    public final static List<Card> getCards() {
        return cards;
    }

    public final static List<BankAccount> getAccounts() {
        return bankAccounts;
    }
}
