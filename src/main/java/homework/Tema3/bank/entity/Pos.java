package homework.Tema3.bank.entity;

import java.util.ArrayList;
import java.util.List;

public class Pos {
    private List<BankAccount> bankAccounts;

    public void addKnownBankAccounts(BankAccount bankAccount)
    {
        this.bankAccounts = new ArrayList<BankAccount>();
        this.bankAccounts.add(bankAccount);
    }

    public String pay(long amount, Card card) throws Exception {
        for (BankAccount account:bankAccounts) {
            for (Card accountCard: account.getAttachedCardNumber()) {
                if(accountCard.getCardNumber() == card.getCardNumber()){
                    account.withdrawMoney(amount);
                }
            }
        }

        String receipt = "You receipt is here!";
        return receipt;
    }
}
