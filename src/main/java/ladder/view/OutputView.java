package ladder.view;

import ladder.model.Game;
import ladder.model.Ladder;
import ladder.model.Player;
import ladder.model.Result;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OutputView {
    private static final int MINIMUM_SPACES = 1;
    private static final String BLANK = " ";
    private static final String HORIZONTAL_LINE = "-";
    private static final String VERTICAL_LINE = "|";

    public static void printGame(Game game) {
        final List<String> names = game.getPlayers().stream().map(x -> x.getName()).collect(Collectors.toList());
        final List<String> rewards = game.getPlayers().stream().map(x -> x.getReward()).collect(Collectors.toList());
        final int maxLength = Stream.concat(names.stream(), rewards.stream()).max(Comparator.comparing(String::length)).get().length();
        final int offset = (maxLength - Math.max(names.get(0).length(), rewards.get(0).length())) / 2;
        System.out.println("\n사다리 결과\n");
        printWords(names, maxLength, offset);
        printLadder(game.getLadder(), maxLength, offset);
        printWords(rewards, maxLength, offset);
    }

    private static void printWords(List<String> words, int maxLength, int offset) {
        final StringBuilder result = new StringBuilder();
        words.forEach(word -> {
            final int leftPadding = (maxLength - word.length()) / 2;
            final int rightPadding = maxLength - word.length() - leftPadding;
            result.append(repeatChar(BLANK, leftPadding + MINIMUM_SPACES) + word + repeatChar(BLANK, rightPadding + MINIMUM_SPACES));
        });
        System.out.println(result.toString().substring(offset));
    }

    private static void printLadder(Ladder ladder, int maxLength, int offset) {
        ladder.getLevels().forEach(level -> {
            StringBuilder result = new StringBuilder(repeatChar(BLANK, (maxLength - VERTICAL_LINE.length()) / 2 + MINIMUM_SPACES) + VERTICAL_LINE);
            for (int i = 0; i < ladder.getWidth() - 1; i++) {
                result.append(drawHorizontalLine(level.getVerticalLines().contains(i), maxLength - VERTICAL_LINE.length() + 2 * MINIMUM_SPACES) + VERTICAL_LINE);
            }
            System.out.println(result.toString().substring(offset));
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

    public static boolean printResult(Result result) {
        if (!result.hasNext()) {
            System.out.println("\n존재하지 않는 참여자입니다. 프로그램을 종료합니다.");
            return false;
        }
        System.out.println("\n실행 결과");
        while (result.hasNext()) {
            Player player = result.next();
            System.out.println(player.getName() + " : " + player.getReward());
        }
        return true;
    }
}