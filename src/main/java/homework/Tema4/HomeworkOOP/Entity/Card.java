package homework.Tema4.HomeworkOOP.Entity;

public class Card {
    private int expirationDate;
    private String ownerName;
    private long cardNumber;

    private int pinNumber;

    public Card(int expirationDate,long cardNumber,String ownerName, int pinNumber){
        this.expirationDate = expirationDate;
        this.cardNumber = cardNumber;
        this.ownerName = ownerName;
        this.pinNumber = pinNumber;
    }

    public int getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(int expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }
}
