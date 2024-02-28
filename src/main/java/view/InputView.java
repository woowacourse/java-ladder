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
        try {
            String input = bufferedReader.readLine();
            String removedInput = removeBlank(input);
            return split(removedInput);
        } catch (IOException e) {
            throw new IllegalArgumentException("비정상적인 입력입니다. 다시 입력해주세요.");
        }
    }

    public List<String> readPrizeNames() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        try {
            String input = bufferedReader.readLine();
            String removedInput = removeBlank(input);
            return split(removedInput);
        } catch (IOException e) {
            throw new IllegalArgumentException("비정상적인 입력입니다. 다시 입력해주세요.");
        }
    }

    public String readPlayerForResultViewing() {
        System.out.println("결과를 보고 싶은 사람은?");
        try {
            String input = bufferedReader.readLine();
            return removeBlank(input);
        } catch (IOException e) {
            throw new IllegalArgumentException("비정상적인 입력입니다. 다시 입력해주세요.");
        }
    }

    public int readHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        try {
            String input = bufferedReader.readLine();
            return Integer.parseInt(input);
        } catch (NumberFormatException | IOException e) {
            throw new IllegalArgumentException("높이는 최소 2이상, 최대 10이하의 숫자만 가능합니다.");
        }
    }

    private String removeBlank(String input) {
        return input.replaceAll(" ", "");
    }

    private List<String> split(String input) {
        return Arrays.asList(input.split(","));
    }
}
