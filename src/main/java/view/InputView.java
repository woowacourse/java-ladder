package view;

import java.util.Scanner;

import static java.lang.System.lineSeparator;

public class InputView {
    private static final Scanner reader = new Scanner(System.in);
    private static final String USER_NAME_DELIMITER = ",";
    private static final String PRIZE_NAME_DELIMITER = ",";


    public String[] readNames() {
        printNamesInputMessage();
        return removeBlank(reader.nextLine()).split(USER_NAME_DELIMITER);
    }

    private void printNamesInputMessage() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    private String removeBlank(final String text) {
        return text.replace(" ", "");
    }

    public String[] readPrizes() {
        printPrizesInputMessage();
        return removeBlank(reader.nextLine()).split(PRIZE_NAME_DELIMITER);
    }

    private void printPrizesInputMessage() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    }

    public int readHeight() {
        printLadderHeightInputMessage();
        try {
            return Integer.parseInt(reader.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자를 입력해 주세요.");
        }
    }

    private void printLadderHeightInputMessage() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public String readName() {
        printNameToSearchInputMessage();
        return removeBlank(reader.nextLine());
    }

    private void printNameToSearchInputMessage() {
        System.out.println(lineSeparator() + "결과를 보고 싶은 사람은? 종료를 원하면 \"END\"를 입력해 주세요.");
    }
}
