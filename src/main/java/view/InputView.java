package view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public String inputName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = scanner.nextLine();
        InputValidator.validateIsNotCommand(input);
        return input;
    }

    public String inputPrizes() {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    public String inputHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        return scanner.nextLine();
    }

    public String inputPlayerName() {
        System.out.println("\n결과를 보고 싶은 사람은?");
        String input = scanner.nextLine();
        InputValidator.validatePlayerName(input);
        return input;
    }
}
