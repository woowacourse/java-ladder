package view;

import domain.Height;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class InputView {

    public static List<String> readNames(Supplier<String> input) {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String inputString = input.get();
        validateEmpty(inputString);
        validateEndedWithComma(inputString);
        return Arrays.stream(inputString.split(","))
                .peek(InputView::validateEmpty)
                .map(String::trim)
                .toList();
    }

    private static void validateEmpty(String inputString) {
        if (inputString == null || inputString.isBlank()) {
            throw new IllegalArgumentException("null 혹은 빈 문자열을 입력할 수 없습니다.");
        }
    }

    private static void validateEndedWithComma(String inputString) {
        if (inputString.endsWith(",")){
            throw new IllegalArgumentException("null 혹은 빈 문자열을 입력할 수 없습니다.");
        }
    }

    public static Height readHeight(Supplier<String> input) {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String inputString = input.get();
        validateEmpty(inputString);
        validateInteger(inputString);
        return new Height(Integer.parseInt(inputString));
    }

    private static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수를 입력해야 합니다.");
        }
    }

    public static List<String> readWinnings(Supplier<String> input) {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String inputString = input.get();
        validateEmpty(inputString);
        validateEndedWithComma(inputString);
        return Arrays.stream(inputString.split(","))
                .peek(InputView::validateEmpty)
                .map(String::trim)
                .toList();
    }
}
