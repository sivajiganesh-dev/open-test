import java.util.*;

public class SortByOccurrences {
    public static void main(String[] args) {

        //Hard-coded sample data
        List<Integer> items;

        if(args.length > 0 && args[0].equals("1")){
            items = getListFromInput();
        }else {
            items = getListFromLocal() ;
        }

        System.out.println(items);

        //Find out the occurrences of the numbers
        Map<Integer, Integer> countedNums = new HashMap<>();
        items.parallelStream().forEach(integer -> {
            int count = (countedNums.getOrDefault(integer, 0) + 1);
            countedNums.put(integer, count);
        });

        //Map and Sort the occurrences-to-numbers
        SortedMap<Integer, List<Integer>> sortedCountedNums = new TreeMap<>();
        for (Map.Entry<Integer, Integer> num : countedNums.entrySet()) {
            List<Integer> keys = sortedCountedNums.getOrDefault(num.getValue(), new ArrayList<>());
            keys.add(num.getKey());
            sortedCountedNums.put(num.getValue(), keys);
        }


        //Create sorted list by adding sorted numbers to list occurred times
        List<Integer> sortedList = new ArrayList<>();
        sortedCountedNums.forEach((count, numbers) -> numbers.stream()
                .sorted()
                .forEach(num -> sortedList
                        .addAll(Collections.nCopies(count, num))
                )
        );

        System.out.println(sortedList);
    }

    public static List<Integer> getListFromInput(){
        List<Integer> integers = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.next().trim().split(",");

        for (String number : numbers) {
            integers.add(Integer.parseInt(number));
        }

        return integers;
    }

    public static List<Integer> getListFromLocal(){
        List<Integer> items = new ArrayList<>();

        items.add(1);
        items.add(1);
        items.add(5);
        items.add(3);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(6);
        items.add(5);

        return items;
    }

}
