package view;

import exception.EmptyException;
import exception.NullException;

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

    public List<String> readUserNames() {
        System.out.println(NAME_INPUT_REQUEST);
        String inputUserNames = scanner.nextLine();
        List<String> playersNames = splitInputValues(inputUserNames);
        checkNameEmpty(playersNames);
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
        checkNameEmpty(inputProducts);
        return inputProducts;
    }

    public String readResult() {
        System.out.println(RESULT_OF_PLAYERNAME);
        String inputResult = scanner.nextLine();
        checkEmpty(inputResult);
        return inputResult;
    }

    private List<String> splitInputValues(String inputUserNames) {
        return Arrays.asList(inputUserNames.split(DELIMITER, -1));
    }

    private void checkInputHeight(String inputHeight) {
        try {
            Integer.parseInt(inputHeight);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNameEmpty(List<String> playersNames) {
        checkNameBlank(playersNames);
        checkNameNull(playersNames);
    }

    private void checkEmpty(String productOfPlayerName) {
        checkBlank(productOfPlayerName);
        checkNull(productOfPlayerName);
    }

    private void checkNameBlank(List<String> playersNames) {
        if (playersNames.isEmpty()) {
            throw new EmptyException();
        }
    }

    private void checkNameNull(List<String> playersNames) {
        if (playersNames == null) {
            throw new NullException();
        }
    }

    private void checkNull(String productOfPlayerName) {
        if (productOfPlayerName == null) {
            throw new NullException();
        }
    }

    private void checkBlank(String productOfPlayerName) {
        if (productOfPlayerName.isEmpty()) {
            throw new EmptyException();
        }
    }
}
