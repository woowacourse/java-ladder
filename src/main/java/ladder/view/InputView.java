package ladder.view;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String NAME_DELIMITER = ",";

    public List<String> inputPlayerNames() {
        System.out.println();
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        String names = SCANNER.nextLine();
        SCANNER.reset();
        return Arrays.asList(names.split(NAME_DELIMITER));
    }

    public int inputHeight() {
        System.out.println();
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        try {
            return new Scanner(System.in).nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("사다리 높이는 숫자이여야 합니다.", e);
        } finally {
            SCANNER.reset();
        }
    }
}
