package homework.HomeworkOOP;

import homework.HomeworkOOP.entity.BankAccount;
import homework.HomeworkOOP.entity.Card;
import homework.HomeworkOOP.entity.Pos;
import homework.HomeworkOOP.entity.User;

public class HomeworkOopBank {
    public static void main(String[] args) throws Exception {

        Card card = new Card(112233665, 1112225723564598L, "Toader George");
        BankAccount account = new BankAccount("ROINGB55663365544889");
        account.attachCard(card);

        User client = new User();
        client.addBankAccount(account);
        client.addCard(card);

        for (BankAccount clientAccount: client.getBankAccounts()) {
            clientAccount.addMoney(1200L);
        }


        for (BankAccount clientAccount: client.getBankAccounts()) {
            clientAccount.withdrawMoney(500L);
        }


        for (BankAccount clientAccount: client.getBankAccounts()) {
            long money = clientAccount.getBalance();

            System.out.println("Money available after withdraw= " + money);
        }

        Pos pos = new Pos();
        pos.addKnownBankAccounts(account);
        pos.pay(200,card);


        for (BankAccount clientAccount: client.getBankAccounts()) {
            long money = clientAccount.getBalance();

            System.out.println("Money available after pay= " + money);
        }
    }
}
