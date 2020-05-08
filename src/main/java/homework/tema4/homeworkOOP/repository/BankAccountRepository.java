package homework.tema4.homeworkOOP.repository;


import homework.tema4.homeworkOOP.Entity.BankAccount;
import homework.tema4.homeworkOOP.Entity.Card;

import java.util.ArrayList;
import java.util.List;

public abstract class BankAccountRepository {

    public final static List<Card> attachedCards = new ArrayList<>();

    static {
        Card card1 = new Card(112233442, 1133344455567L, "john Doe", 2233);
        Card card2 = new Card(552733442, 5533344455567L, "john Doe Son", 2233);
        Card card3 = new Card(992233442, 9933344455567L, "john Doe Daughter", 2233);

        attachedCards.add(card1);
        attachedCards.add(card2);
        attachedCards.add(card3);

        BankAccount account2 = new BankAccount("RO9944444444");
        Card card11 = new Card(772233442, 1133344455567L, "john Doe Mother", 2233);
        Card card22 = new Card(662733442, 5533344455567L, "john Doe Father", 2233);
        Card card33 = new Card(882233442, 9933344455567L, "john Doe Dog", 2233);

        attachedCards.add(card11);
        attachedCards.add(card22);
        attachedCards.add(card33);
    }

    public final static List<Card> getAttachedCards(){
        return attachedCards;
    }
}
