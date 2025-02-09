import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

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
        System.out.println("-----------------------------");

        System.out.println("TASK 4 test:");
        System.out.println("-----------------------------");

        System.out.println("TASK 5 test:");
        System.out.println("-----------------------------");
    }

    // TASK 1
    private static String getEvenOddNames(List<String> list, boolean isOdd) {
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
    private static List<String> upperCaseAndSortList(List<String> list, boolean descending){
        return list
                .stream().
                map(String::toUpperCase)
                .sorted(descending ? Comparator.reverseOrder() : Comparator.naturalOrder())

                .collect(Collectors.toList());
    }
}
