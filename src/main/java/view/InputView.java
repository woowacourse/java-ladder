package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String NAME_INPUT_REQUEST = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String PRODUCTS_INPUT_REQUEST = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String RESULT_OF_PLAYERNAME = "결과를 보고 싶은 사람은?";
    private static final String DELIMITER = ",";
    private static final String HEIGHT_INPUT_REQUEST = "최대 사다리 높이는 몇 개인가요?";
    private static final String BLANK_MESSAGE = "[ERROR] 입력값이 비어있습니다.";
    private static final String NULL_MESSAGE = "[ERROR] 아무것도 입력하지 않았습니다.";

    public List<String> readUserNames() {
        System.out.println(NAME_INPUT_REQUEST);
        String inputUserNames = scanner.nextLine();
        List<String> playersNames = splitInputValues(inputUserNames);
        checkDelimiterEmptied(playersNames);
        return playersNames;
    }

    public int readHeight() {
        System.out.println(HEIGHT_INPUT_REQUEST);
        String inputHeight = scanner.nextLine();
        checkInputHeight(inputHeight);
        return Integer.parseInt(inputHeight);
    }

    public List<String> readProducts() {
        System.out.println(PRODUCTS_INPUT_REQUEST);
        String inputProduct = scanner.nextLine();
        List<String> inputProducts = splitInputValues(inputProduct);
        checkDelimiteBlank(inputProducts);
        return inputProducts;
    }

    public String readResult() {
        System.out.println(RESULT_OF_PLAYERNAME);
        String inputResult = scanner.nextLine();
        checkEmpty(inputResult);
        return inputResult;
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

    private void checkDelimiterEmptied(List<String> playersNames) {
        checkDelimiteBlank(playersNames);
        checkDelimiteNull(playersNames);
    }

    private void checkEmpty(String productOfPlayerName) {
        checkBlank(productOfPlayerName);
        checkNull(productOfPlayerName);
    }
    private void checkDelimiteBlank(List<String> playersNames) {
        if (playersNames.isEmpty()) {
            throw new IllegalArgumentException(BLANK_MESSAGE);
        }
    }

    private void checkDelimiteNull(List<String> playersNames) {
        if (playersNames == null) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
    }

    private void checkNull(String productOfPlayerName) {
        if (productOfPlayerName == null) {
            throw new IllegalArgumentException(NULL_MESSAGE)
        }
    }
    private void checkBlank(String productOfPlayerName) {
        if (productOfPlayerName.isEmpty()) {
            throw new IllegalArgumentException(BLANK_MESSAGE);
        }
    }
}
