package ladder.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
    public static void printNames(List<String> names) {
        System.out.println(parseDisplayNames(names));
    }

    private static String parseDisplayNames(List<String> names) {
        return IntStream.range(0, names.size())
                .mapToObj(nameIndex -> parseDisplayName(names, nameIndex))
                .collect(Collectors.joining());
    }

    private static String parseDisplayName(List<String> names, int nameIndex) {
        if (nameIndex == 0) {
            return names.get(nameIndex);
        }
        return String.format("%6s", names.get(nameIndex));
    }
}
