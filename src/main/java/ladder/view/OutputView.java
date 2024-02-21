package ladder.view;

import ladder.dto.LadderResult;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {

    public static void printLadderResult(LadderResult ladderResult) {
        System.out.println("실행결과");
        System.out.println();
        System.out.println(makeNameMessage(ladderResult.names()));
    }

    private static String makeNameMessage(List<String> userNames) {
        int middle = userNames.size() / 2;
        String s1 = makeName(0, middle, "%5s", userNames);
        String s2 = makeName(middle, userNames.size(), "%-5s", userNames);
        return String.join(" ", s1, s2);
    }

    private static String formatName(String type, String name) {
        return String.format(type, name);
    }

    private static String makeName(int start, int end, String type, List<String> userNames) {
        return IntStream.range(start, end)
                .mapToObj(i -> formatName(type, userNames.get(i)))
                .collect(Collectors.joining(" "));
    }
}
