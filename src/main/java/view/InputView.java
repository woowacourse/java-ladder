package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public List<String> readPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return getUserInput();
    }

    public List<String> readResults() {
        System.out.println();
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return getUserInput();
    }

    private List<String> getUserInput() {
        String input = getInput();
        String removedInput = removeBlank(input);
        return split(removedInput);
    }

    private String getInput() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException("입력을 받는 도중 에러가 발생했습니다.");
        }
    }

    public int readHeight() {
        System.out.println();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        try {
            String input = getInput();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("높이는 최소 2이상, 최대 10이하의 숫자만 가능합니다.");
        }
    }

    public String readPlayerResult() {
        System.out.println();
        System.out.println("결과를 보고 싶은 사람은?");
        return removeBlank(getInput());
    }

    private String removeBlank(String input) {
        return input.replaceAll(" ", "");
    }

    private List<String> split(String input) {
        return Arrays.asList(input.split(","));
    }
}
