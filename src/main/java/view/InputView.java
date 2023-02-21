package view;

import domain.ladder.LadderHeight;
import domain.player.Name;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String NAME_DELIMITER = ",";
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public List<Name> readNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        String rawNames = scanner.nextLine();
        return Arrays.stream(rawNames.split(NAME_DELIMITER))
                .map(String::trim)
                .map(Name::new)
                .collect(Collectors.toList());
    }

    public LadderHeight readLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        int height = parseInt(scanner.nextLine());
        return new LadderHeight(height);
    }

    private static int parseInt(String rawLadderHeight) {
        try {
            return Integer.parseInt(rawLadderHeight);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("사다리의 높이는 숫자여야합니다. " +
                    "입력값: %s", rawLadderHeight));
        }
    }
}
