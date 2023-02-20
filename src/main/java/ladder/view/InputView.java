package ladder.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String NAMES_DELIMITER = ",";
    private static final Scanner scanner = new Scanner(System.in);

    public List<String> readParticipantNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] names = scanner.nextLine()
                                .split(NAMES_DELIMITER);
        return List.of(names);
    }

    public int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("사다리 높이는 숫자입니다");
        }
    }
}
