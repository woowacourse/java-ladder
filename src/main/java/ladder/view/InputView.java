package ladder.view;

import java.util.List;
import java.util.function.Supplier;

import static java.util.Arrays.stream;

public class InputView {

    private InputView() {
        throw new AssertionError();
    }

    public static List<String> readNames(Supplier<String> reader) throws IllegalArgumentException {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = reader.get();
        validateEmpty(input);
        System.out.println();
        return splitInput(input);
    }

    public static int readLadderHeight(Supplier<String> reader) throws IllegalArgumentException {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String input = reader.get();
        validateEmpty(input);
        System.out.println();
        return parseLadderHeight(input);
    }

    public static List<String> readDestinations(Supplier<String> reader) throws IllegalArgumentException {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String input = reader.get();
        validateEmpty(input);
        System.out.println();
        return splitInput(input);
    }

    public static String readRequestResult(Supplier<String> reader) throws IllegalArgumentException {
        String input = reader.get();
        validateEmpty(input);
        return input;
    }

    private static void validateEmpty(final String input) throws IllegalArgumentException {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("공백을 넣을 수 없습니다.");
        }
    }

    private static List<String> splitInput(String input) {
        return stream(input.split(","))
                .toList();
    }

    private static int parseLadderHeight(final String input) throws IllegalArgumentException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("사다리 높이에는 숫자를 입력해야 합니다");
        }
    }
}
