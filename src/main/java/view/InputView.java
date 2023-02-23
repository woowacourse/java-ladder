package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String NAME_INPUT_REQUEST = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String DELIMITER = ",";
    private static final String HEIGHT_INPUT_REQUEST = "최대 사다리 높이는 몇 개인가요?";
    private static final String BLANK_MESSAGE = "[ERROR] 입력값이 비어있습니다.";
    private static final String NULL_MESSAGE = "[ERROR] 아무것도 입력하지 않았습니다.";

    public List<String> readUserNames() {
        System.out.println(NAME_INPUT_REQUEST);
        String inputUserNames = scanner.nextLine();
        List<String> playersNames = splitInputValues(inputUserNames);
        checkEmpty(playersNames);
        return playersNames;
    }

    public int readHeight() {
        System.out.println(HEIGHT_INPUT_REQUEST);
        String inputHeight = scanner.nextLine();
        checkInputHeight(inputHeight);
        return Integer.parseInt(inputHeight);
    }

    public List<String> readProducts() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String inputProduct = scanner.nextLine();
        List<String> inputProducts = splitInputValues(inputProduct);
        checkEmpty(inputProducts);
        return inputProducts;
    }

    private List<String> splitInputValues(String inputUserNames) {
        return Arrays.asList(inputUserNames.split(DELIMITER,-1));
    }

    private void checkInputHeight(String inputHeight) {
        try {
            Integer.parseInt(inputHeight);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    private void checkEmpty(List<String> playersNames) {
        checkBlank(playersNames);
        checkNull(playersNames);
    }
    private static void checkBlank(List<String> playersNames) {
        if (playersNames.isEmpty()) {
            throw new IllegalArgumentException(BLANK_MESSAGE);
        }
    }

    private static void checkNull(List<String> playersNames) {
        if (playersNames == null) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
    }
}
