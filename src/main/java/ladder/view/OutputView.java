package ladder.view;

import ladder.model.Ladder;
import ladder.model.Result;

import java.util.List;

public class OutputView {
    private static final String BLANK = " ";
    private static final String HORIZONTAL_LINE = "-";
    private static final String VERTICAL_LINE = "|";

    public static void printGame(List<String> people, Ladder ladder, List<String> rewards, int wordMaxLength) {
        System.out.println("\n사다리 결과\n");
        printWords(people, wordMaxLength);
        printLadder(ladder, wordMaxLength);
        printWords(rewards, wordMaxLength);
    }

    private static void printWords(List<String> words, int maxLength) {
        StringBuilder namesWithPadding = new StringBuilder();
        words.forEach(word -> {
            String padding = repeatChar(BLANK, (maxLength - word.length()) / 2);
            namesWithPadding.append(BLANK + padding + word + padding + BLANK);
        });
        System.out.println(namesWithPadding.toString());
    }

    private static void printLadder(Ladder ladder, int length) {
        final int ladderWidth = ladder.getWidth();
        ladder.getLevels().forEach(level -> {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < ladderWidth - 1; i++) {
                result.append(VERTICAL_LINE + drawHorizontalLine(level.getLines().contains(i), length));
            }
            result.append(VERTICAL_LINE);
            System.out.println(result);
        });
    }

    private static String drawHorizontalLine(boolean exists, int width) {
        if (exists) {
            return repeatChar(HORIZONTAL_LINE, width);
        }
        return repeatChar(BLANK, width);
    }

    private static String repeatChar(String text, int n) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(text);
        }
        return result.toString();
    }

    public static void printResult(Result result) {
        if (!result.hasNext()) {
            System.out.println("존재하지 않는 참여자입니다. 다시 입력해주세요.");
            return;
        }
        while (result.hasNext()) {
            result.next().entrySet().forEach(x -> System.out.println(x.getKey() + " : " + x.getValue()));
        }

    }
}