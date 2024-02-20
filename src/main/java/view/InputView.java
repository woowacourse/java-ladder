package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String SPLIT_DELIMITER = ",";
    private static final String ASK_PLAYER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";


    private InputView() {
    }

    public static List<String> askPlayerNames() {
        System.out.println(ASK_PLAYER_NAMES);
        String input = scanner.nextLine();
        return parsePlayerNames(input);
    }

    private static List<String> parsePlayerNames(String input) {
        return Arrays.stream(input.split(SPLIT_DELIMITER))
                .map(String::strip)
                .toList();
    }
}
