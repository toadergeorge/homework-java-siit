package homework.tema8.ex3;

import lombok.Data;

@Data
public class Transaction {

    private final Trader trader;

    private final int year;

    private final int value;
}
