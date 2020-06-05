package homework.tema10.entity;

public enum TicketType {
    FULL, FULL_VIP, FREE_PASS, ONE_DAY, ONE_DAY_VIP;

    public static TicketType getRandom() {
        return TicketType.values()[(int) (Math.random() * TicketType.values().length)];
    }
}

