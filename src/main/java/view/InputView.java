package view;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_USER_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_LADDER_HEIGHT = "\n최대 사다리 높이는 몇 개인가요?";
    public static final String HEIGHT_FORMAT_ERROR_MESSAGE = "[ERROR] 사다리 높이는 숫자만 가능합니다.";
    public static final String INPUT_NOTHING_ERROR_MESSAGE = "[ERROR] 값을 입력하지 않았습니다.";
    public static final String INPUT_RESULTS = "\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    public static final String HEIGHT_REGEX_FORMAT = "^[0-9]*$";
    public static final String RESULT_LENGTH_ERROR = "[ERROR] 참여하는 인원에 맞게 결과값을 입력해 주세요.";
    public static final String INPUT_RESULT_USERNAME = "\n결과를 보고 싶은 사람은?";
    static Scanner sc = new Scanner(System.in);

    public List<String> inputUserName() {
        System.out.println(INPUT_USER_NAME);
        return splitNameInput(sc.nextLine());
    }

    private List<String> splitNameInput(String nameInput) {
        return List.of(nameInput.split(","));
    }

    public int inputLadderHeight() {
        System.out.println(INPUT_LADDER_HEIGHT);
        String heightInput = sc.nextLine();
        validateHeightFormat(heightInput);
        return Integer.parseInt(heightInput);
    }

    private void validateHeightFormat(String heightInput) {
        if (!heightInput.matches(HEIGHT_REGEX_FORMAT)) {
            throw new IllegalArgumentException(HEIGHT_FORMAT_ERROR_MESSAGE);
        }
        if (heightInput.isEmpty()) {
            throw new IllegalArgumentException(INPUT_NOTHING_ERROR_MESSAGE);
        }
    }

    public List<String> inputResults() {
        System.out.println(INPUT_RESULTS);
        return splitNameInput(sc.nextLine());
    }

    public String inputResultUser() {
        System.out.println(INPUT_RESULT_USERNAME);
        return sc.nextLine();
    }
}
