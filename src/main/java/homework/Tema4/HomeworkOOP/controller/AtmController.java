package homework.Tema4.HomeworkOOP.controller;


import homework.Tema4.HomeworkOOP.Entity.Card;
import homework.Tema4.HomeworkOOP.service.BankAccountService;
import homework.Tema4.HomeworkOOP.service.CardAccountService;

import java.util.Scanner;

public class AtmController {

    private BankAccountService bankAccountService;
    private CardAccountService cardAccountService;

    public AtmController() {
        this.bankAccountService = new BankAccountService();
        this.cardAccountService = new CardAccountService();
    }

    public static void main(String[] args) throws Exception {

        AtmController atmController = new AtmController();
        Scanner scanner = new Scanner(System.in);

        int startOption = 0;
        while (startOption == 0) {
            try {

                System.out.println("Introduceti numarul cardului:");
                String cardNumberString = scanner.next();

                System.out.println("Introduceti pinul cardului:");
                int cardPin = scanner.nextInt();

                long cardNumber = Long.parseLong(cardNumberString);
                Card userCard = atmController.cardAccountService.getUserCardByNumberAndPin(cardNumber, cardPin);

                if (userCard == null) {
                    throw new Exception("Card was not found!");
                }

                //it runs forever
                getAtmOptions(scanner, atmController, userCard);
                //we can put a new startOption here to stop the cycle

                //startOption = 1;
            } catch (Exception e) {
                System.out.println("A aparut o eroare, va rugam sa incercati din nou!");
                startOption = 0;
            }
        }
    }

    private static void getAtmOptions(Scanner scanner, AtmController atmController, Card userCard) {
        System.out.println("Alegeti actiunea dorita:");
        System.out.println("Keyboard 1: Withdraw \n Keyboard 2: Deposit \n Keyboard 3: Change card pin number\n Keyboard 4: Interogate Balance\n Keyboard 5: Exit");
        int option = scanner.nextInt();

        boolean begin = true;
        while (option >= 0 && option < 6) {

            if (begin == false) {
                System.out.println("Alegeti actiunea dorita:");
                System.out.println("Keyboard 1: Withdraw \n Keyboard 2: Deposit \n Keyboard 3: Change card pin number\n Keyboard 4: Interogate Balance\n Keyboard 5: Exit");
                option = scanner.nextInt();
            }

            switch (option) {
                case 1:
                    try {
                        System.out.println("Introduceti suma care doriti sa o extrageti:");
                        String amountString = scanner.next();
                        long amount = Long.parseLong(amountString);
                        atmController.bankAccountService.withdrawMoney(userCard, amount);
                    } catch (Exception e) {
                        System.out.println("A aparut o eroare:" + e.getMessage());
                    }

                    break;
                case 2:
                    try {
                        System.out.println("Introduceti suma care doriti sa o depuneti:");
                        String amountString = scanner.next();
                        long amount = Long.parseLong(amountString);
                        atmController.bankAccountService.addMoney(userCard, amount);
                    } catch (Exception e) {
                        System.out.println("A aparut o eroare:" + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        boolean wrongPin = true;
                        while (wrongPin) {
                            System.out.println("Introduceti noul numar pin(4 cifre):");
                            int newPin = scanner.nextInt();
                            int pinSize = String.valueOf(newPin).length();

                            if ((pinSize == 4 && newPin > 0) || newPin == 0) {
                                wrongPin = false;

                                if (newPin != 0) {
                                    atmController.cardAccountService.changeCardPin(userCard, newPin);
                                }

                            } else {
                                System.out.println("Pinul este gresit! Incercati inca odata!");
                                System.out.println("Pentru a renunta la schimbarea de pin tastati tasta 0 si enter!");
                            }
                        }

                    } catch (Exception e) {
                        System.out.println("A aparut o eroare:" + e.getMessage());
                    }
                    break;
                case 4:

                    try {
                        long soldBalance = atmController.bankAccountService.getAccountBalance(userCard);
                        System.out.println("Soldul cardului dumneavoastra este :" + soldBalance);
                    } catch (Exception e) {
                        System.out.println("A aparut o eroare:" + e.getMessage());
                    }
                    break;

                case 5:
                    option = 6;
                    System.out.println("Exit");
                    break;
            }
            begin = false;
        }
    }

}

