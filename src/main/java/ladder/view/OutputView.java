package ladder.view;

import ladder.model.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OutputView {
    private static final int MIN_SPACE = 2;
    private static final String BLANK = " ";
    private static final String HORIZ_LINE = "-";
    private static final String VERT_LINE = "|";

    public static void printGame(Game game) {
        final List<String> names = game.getPlayers().stream().map(x -> x.getName()).collect(Collectors.toList());
        final List<String> rewards = game.getPlayers().stream().map(x -> x.getReward()).collect(Collectors.toList());
        final int maxLength = Stream.concat(names.stream(), rewards.stream())
            .max(Comparator.comparing(String::length)).get().length();
        final int offset = (maxLength - Math.max(names.get(0).length(), rewards.get(0).length())) / 2;
        System.out.println("\n사다리 결과\n");
        printWords(names, maxLength, offset);
        printLadder(game.getLadder(), maxLength, offset);
        printWords(rewards, maxLength, offset);
    }

    private static void printWords(List<String> words, int maxLength, int offset) {
        final StringBuilder result = new StringBuilder();
        words.forEach(word -> {
            final int leftPadding = (maxLength - word.length()) / 2 + MIN_SPACE;
            final int rightPadding = maxLength + 2 * MIN_SPACE - word.length() - leftPadding;
            result.append(repeatChar(BLANK, leftPadding) + word + repeatChar(BLANK, rightPadding));
        });
        System.out.println(result.toString().substring(offset));
    }

    private static void printLadder(Ladder ladder, int maxLength, int offset) {
        final int initialSpace = (maxLength - VERT_LINE.length()) / 2 + MIN_SPACE;
        final int space = maxLength - VERT_LINE.length() + 2 * MIN_SPACE;
        ladder.getLevels().forEach(level -> printLevel(level, initialSpace, space, ladder.getWidth(), offset));
    }

    private static void printLevel(Level level, int initialSpace, int space, int width, int offset) {
        StringBuilder result = new StringBuilder(repeatChar(BLANK, initialSpace) + VERT_LINE);
        for (int i = 0; i < width - 1; i++) {
            result.append(drawHorizontalLine(level.getVerticalLines().contains(i), space) + VERT_LINE);
        }
        System.out.println(result.toString().substring(offset));
    }
    private static String drawHorizontalLine(boolean exists, int width) {
        if (exists) {
            return repeatChar(HORIZ_LINE, width);
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

    public static boolean printResult(Result result) {
        System.out.println("\n실행 결과");
        if (!result.hasNext()) {
            System.out.println("존재하지 않는 참여자입니다. 프로그램을 종료합니다.");
            return false;
        }
        while (result.hasNext()) {
            Player player = result.next();
            System.out.println(player.getName() + " : " + player.getReward());
        }
        return true;
    }
}