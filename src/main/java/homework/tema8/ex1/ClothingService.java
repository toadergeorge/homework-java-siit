package homework.tema8.ex1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClothingService {
    public static void main(String[] args) {

        Integer[] socks = {10,10,10,10,30,50,20,20,20,20,20,20};

        getSockPairs(socks);

        System.out.println("Result is " + getSockPairs(socks));
    }

    static int getSockPairs(Integer[] socksPile){

        Stream<Integer> stream = Arrays.stream(socksPile);

        Map<Integer, List<Integer>> numberOfPairs =   stream.
                collect(Collectors.groupingBy(sockColor -> sockColor));

        return numberOfPairs
                .entrySet()
                .stream()
                .map(element -> Math.floorDiv(element.getValue().size(),2))
                .mapToInt(element -> element)
                .sum();
    }
}
