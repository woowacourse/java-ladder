package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String SPLIT_DELIMITER = ",";

    private final Scanner reader = new Scanner(System.in);

    public List<String> readPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String playerNames = reader.next();
        return Arrays.stream(splitNames(playerNames))
                .collect(Collectors.toList());
    }

    private String[] splitNames(String playerNames) {
        return playerNames.split(SPLIT_DELIMITER);
    }

    public int readHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String input = reader.next();
        int ladderHeight = validateIntegerInput(input);
        return ladderHeight;
    }

    private int validateIntegerInput(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("사다리 높이의 입력 값은 숫자만 가능합니다.");
        }
    }
}
