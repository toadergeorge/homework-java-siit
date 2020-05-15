package homework.tema8.ex3;

import java.util.*;
import java.util.stream.Collectors;

public class WallStreetService {

    static Trader raoul = new Trader("Raoul", "Cambridge");

    static Trader mario = new Trader("Mario", "Milan");

    static Trader alan = new Trader("Alan", "Cambridge");

    static Trader brian = new Trader("Brian", "Cambridge");

    static List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    public static void main(String... args) {

        getTradersFromCity("Cambridge").forEach(System.out::println);
        getAllTradersNames().forEach(System.out::println);
        System.out.println(" aaa = " +  existsTraderInCity("Cambridge"));
        System.out.println("suma " + getTransactionValueByCity("Cambridge"));
        System.out.println("val maxima " + getMaxTransactionValue());
        System.out.println("val min " + getMinTransactionValue());



    }

    //8. Find the transaction with the smallest value.
    static long getMinTransactionValue(){
        return transactions.stream()
                .map(Transaction::getValue)
                .min(Comparator.comparing(Integer::intValue))
                .get();
    }

    //7. What’s the highest value of all the transactions?
    static long getMaxTransactionValue(){
        return transactions.stream()
                .map(Transaction::getValue)
                .max(Comparator.comparing(Integer::intValue))
                .get();
    }

    //6. Print all transactions’ values from the traders living in Cambridge.
    static long getTransactionValueByCity(String city){
        return transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals(city))
                .mapToInt(Transaction::getValue)
                .sum();
    }

    //5. Are any traders based in Milan?.
    static long existsTraderInCity(String city){
        return transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals(city))
                .distinct()
                .count();
    }

    //4. Return a string of all traders’ names sorted alphabetically.
    static Set<String> getAllTradersNames(){
        return transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    //3. Find all traders from Cambridge and sort them by name.
    static Set<String> getTradersFromCity(String city) {
        return transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals(city))
                .map(Trader::getName)
                .collect(Collectors.toCollection(TreeSet::new));
    }
}
