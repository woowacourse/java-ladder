package laddergame.view;

import java.util.List;
import laddergame.util.ExceptionMessageFormatter;
import laddergame.view.util.ConsoleReader;

public class InputView {

    private static final List<String> RESERVED_WORDS = List.of("all", "q");

    public static List<String> askPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        final List<String> playerNames = ConsoleReader.readLineByDelimiter(",");
        playerNames.forEach(InputView::validateReserved);
        return playerNames;
    }

    private static void validateReserved(final String name) {
        if (isReservedWord(name)) {
            final String message = "참여자의 이름은 예약어와 일치할 수 없습니다.";
            throw new IllegalArgumentException(ExceptionMessageFormatter.format(message, name));
        }
    }

    private static boolean isReservedWord(final String name) {
        return RESERVED_WORDS.stream()
                .anyMatch(invalidName -> invalidName.equalsIgnoreCase(name));
    }

    public static List<String> askDestinationItems() {
        System.out.println();
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return ConsoleReader.readLineByDelimiter(",");
    }

    public static int askLadderHeight() {
        System.out.println();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return ConsoleReader.readNaturalNumber();
    }

    public static String askSearchKeyword() {
        System.out.println();
        System.out.println("결과를 보고 싶은 사람은?");
        return ConsoleReader.readLine();
    }
}
