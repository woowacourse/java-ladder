package ladder.view;

import ladder.model.Game;
import ladder.model.Ladder;
import ladder.model.Player;
import ladder.model.Result;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Output {
    private static final int MIN_SPACE = 2;
    private static final String BLANK = " ";
    private static final String HORIZON_LINE = "-";
    private static final String VERTICAL_LINE = "|";

    private static String LADDER_RESULT;
    private static String RUN_RESULT;
    private static String NON_EXIST_PLAYER;

    static {
        LADDER_RESULT = "\n사다리 결과\n";
        RUN_RESULT = "\n실행 결과";
        NON_EXIST_PLAYER = "존재하지 않는 참여자입니다. 프로그램을 종료합니다.";
    }

    public static void game(Game game) {
        final List<Player> players = game.getPlayers();
        final List<String> names = getPlayersField(players, Player::getName);
        final List<String> rewards = getPlayersField(players, Player::getReward);
        final int maxLength = Stream
                .concat(names.stream(), rewards.stream())
                .max(Comparator.comparing(String::length))
                .get()
                .length();
        final int offset = (maxLength - Math.max(names.get(0).length(), rewards.get(0).length())) / 2;
        System.out.println(LADDER_RESULT);
        words(names, maxLength, offset);
        ladder(game.getLadder(), maxLength, offset);
        words(rewards, maxLength, offset);
    }

    private static List<String> getPlayersField(List<Player> players, Function<Player, String> mapper) {
        return players.stream().map(mapper).collect(Collectors.toList());
    }

    private static void words(List<String> words, int maxLength, int offset) {
        final StringBuilder result = new StringBuilder();
        words.forEach(word -> {
            final int leftPadding = (maxLength - word.length()) / 2 + MIN_SPACE;
            final int rightPadding = maxLength + (2 * MIN_SPACE) - word.length() - leftPadding;
            result.append(repeatChar(BLANK, leftPadding) + word + repeatChar(BLANK, rightPadding));
        });
        System.out.println(result.toString().substring(offset));
    }

    private static void ladder(Ladder ladder, int maxLength, int offset) {
        final int initialSpace = (maxLength - VERTICAL_LINE.length()) / 2 + MIN_SPACE;
        final int space = maxLength - VERTICAL_LINE.length() + 2 * MIN_SPACE;
        ladder.getLevels().forEach(level -> {
            final String leftPadding = repeatChar(BLANK, initialSpace);
            final String result =
                    leftPadding
                    + VERTICAL_LINE
                    + level(level.getLines(), ladder.getWidth(), space);
            System.out.println(result.substring(offset));
        });
    }

    private static String level(List<Integer> lines, int width, int space) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < width - 1; i++) {
            result.append(drawHorizontalLine(lines.contains(i), space) + VERTICAL_LINE);
        }
        return result.toString();
    }

    private static String drawHorizontalLine(boolean exists, int width) {
        if (exists) {
            return repeatChar(HORIZON_LINE, width);
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

    public static boolean result(Result result) {
        System.out.println(RUN_RESULT);
        if (!result.hasNext()) {
            System.out.println(NON_EXIST_PLAYER);
            return false;
        }
        while (result.hasNext()) {
            Player player = result.next();
            System.out.println(player);
        }
        return true;
    }
}