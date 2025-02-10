import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HomeWork11 {
    static List<String> NAMES = List.of("Anton", "Andriy", "Boris", "Maksym", "Vlad", "Ruslan", "Mykola", "Igor");

    public static void main(String[] args) {

        System.out.println("NAMES: " + NAMES);
        System.out.println("TASK 1 test:");
        String oddNames = getEvenOddNames(NAMES, true);
        System.out.println("Odd names string: " + oddNames);
        System.out.println("-----------------------------");

        System.out.println("TASK 2 test:");
        System.out.println("To upper case and desc sort NAMES: " + upperCaseAndSortList(NAMES, true));
        System.out.println("-----------------------------");

        System.out.println("TASK 3 test:");
        System.out.println("To upper case and sort [\"1, 2, 0\", \"4, 5\"]: " + sortingStringIntArray(new String[]{"1, 2, 0", "4, 5"}, false));
        System.out.println("-----------------------------");

        System.out.println("TASK 4 test:");
        Stream<Long> stream = getLinearCongruentGenerator(25214903917L, 11L , 1L << 48);
        System.out.println("10 random values: " + stream.limit(10).toList());
        System.out.println("-----------------------------");

        System.out.println("TASK 5 test:");
        List<Integer> firstList = List.of(0,1,2,3,4,5);
        List<Integer> secondList = List.of(9,8,7,6);
        System.out.println("firstList = " + firstList);
        System.out.println("secondList = " + secondList);
        List<Integer> zipped = zip(firstList.stream(), secondList.stream()).toList();
        System.out.println("zipped (firstList + secondList)= " + zipped);
        System.out.println("-----------------------------");
    }

    // TASK 1
    public static String getEvenOddNames(List<String> list, boolean isOdd) {
        final int remainder = isOdd ? 1 : 0;
        AtomicInteger countFilter = new AtomicInteger(1);
        AtomicInteger countMap = new AtomicInteger(1);

        return list
                .stream()
                .filter(item -> countFilter.getAndIncrement() % 2 == remainder)
                .map(item -> {
                    String newName = countMap.get() + ". " + item;
                    countMap.getAndIncrement();
                    countMap.getAndIncrement();
                    return newName;
                })
                .collect(Collectors.joining(", "));
    }

    // TASK 2
    public static List<String> upperCaseAndSortList(List<String> list, boolean descending){
        return list
                .stream().
                map(String::toUpperCase)
                .sorted(descending ? Comparator.reverseOrder() : Comparator.naturalOrder())

                .collect(Collectors.toList());
    }

    // TASK 3
    public static String sortingStringIntArray(String[] array, boolean descending){
        return Arrays.stream(String.join(", ", array)
                .split(", "))
                .map(item -> "" + Integer.parseInt(item.trim()))
                .sorted(descending ? Comparator.reverseOrder() : Comparator.naturalOrder())
                .collect(Collectors.joining(", "));
    }

    // TASK 4
    public static Stream<Long> getLinearCongruentGenerator(long a, long c, long m){
        Randomizer random = new Randomizer(25214903917L, 11L , 1L << 48);
        return  Stream.iterate(37L, seed -> random.start(seed).next());
    }

    // TASK 5
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){
        List<T> resultList = new ArrayList<>();

        Iterator<T> iteratorA = first.iterator();
        Iterator<T> iteratorB = second.iterator();

        while (iteratorA.hasNext() && iteratorB.hasNext()) {
            resultList.add(iteratorA.next());
            resultList.add(iteratorB.next());
        }

        return resultList.stream();
    }
}
