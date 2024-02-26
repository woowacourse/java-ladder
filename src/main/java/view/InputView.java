package view;

import static java.lang.System.in;
import static java.lang.System.lineSeparator;
import static java.lang.System.out;

import domain.Player;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {

    private static final String MESSAGE_PARTICIPATED_PLAYERS = lineSeparator() + "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String MESSAGE_LADDER_HEIGHT = lineSeparator() + "최대 사다리 높이는 몇 개인가요?";
    private static final Pattern EMPTY_SPACE_PATTERN = Pattern.compile(" ");
    private static final String NAMES_SEPARATOR = ",";

    private static final Scanner scanner = new Scanner(in);

    public static List<Player> readPlayerNames() {
        out.println(MESSAGE_PARTICIPATED_PLAYERS);
        String input = EMPTY_SPACE_PATTERN.matcher(scanner.nextLine()).replaceAll("");
        return Arrays.stream(input.split(NAMES_SEPARATOR))
                .map(Player::new)
                .toList();
    }

    public static int readLadderHeight() throws NumberFormatException {
        out.println(MESSAGE_LADDER_HEIGHT);
        return Integer.parseInt(scanner.nextLine());
    }
}
