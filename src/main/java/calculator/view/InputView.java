package calculator.view;

import calculator.domain.Delimiter;
import calculator.domain.Numbers;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public String startMessage() {
        try {
            System.out.println("계산할 식을 입력해주세요.\n기본 구분자는 쉼표(,)와 콜론(:) 입니다.\n커스텀 구분자는 //[커스텀 구분자]\\n 입니다");
            String input = scanner.nextLine();
            String delimiter = Delimiter.getFromString(input);
            Numbers.getFromString(input, delimiter);
            return input;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return startMessage();
        }
    }
}
