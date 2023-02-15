package view;

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

    //TODO: 수정할 메소드 이름 생각해보기
    public List<String> sendNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        String rawNames = scanner.nextLine();
        return Arrays.stream(rawNames.split(NAME_DELIMITER))
                .collect(Collectors.toList());
    }

    //TODO: return LadderHeight
    public int sendLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        String rawLadderHeight = scanner.nextLine();
        return parseInt(rawLadderHeight);
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
