package view;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {
    private final Scanner scanner;

    public static final Pattern PLAYER_NAMES_INPUT_PATTERN = Pattern.compile("[가-힣a-zA-Z]{1,5}(,[가-힣a-zA-Z]{1,5})*");
    public static final String PLAYER_NAMES_INPUT_DELIMITER = ",";
    public static final String BLANK_SPACE = " ";
    public static final String BLANK_EMPTY = "";

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readPlayerNames() {
        System.out.println(String.format("참여할 사람 이름을 입력하세요. (%s)로 구분하세요)", PLAYER_NAMES_INPUT_DELIMITER));
        return scanner.nextLine();
    }

    public String readLadderHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        return scanner.nextLine();
    }
}
