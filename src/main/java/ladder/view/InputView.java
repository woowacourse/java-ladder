package ladder.view;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String SPLIT_DELIMITER = ",";

    private final Scanner scanner;

    public InputView(InputStream in) {
        this.scanner = new Scanner(in);
    }

    public List<String> getNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요");
        return divideInput();
    }

    public int getHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        String heightInput = scanner.nextLine();
        return parseHeightInputToInteger(heightInput);
    }

    public List<String> getPrizeNames() {
        System.out.println("실행 결과를 입력하세요. (결과를 쉼표(,)로 구분하세요");
        return divideInput();
    }

    private int parseHeightInputToInteger(String heightInput) {
        try {
            return Integer.parseInt(heightInput);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자로 입력을 변환할 수 없습니다.");
        }
    }

    private List<String> divideInput() {
        return List.of(scanner.nextLine().split(SPLIT_DELIMITER));
    }
}
