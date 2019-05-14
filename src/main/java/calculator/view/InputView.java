package calculator.view;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public String startMessage() {
        try {
            System.out.println("계산할 식을 입력해주세요.\n기본 구분자는 쉼표(,)와 콜론(:) 입니다.\n커스텀 구분자는 //[커스텀 구분자]\\n 입니다");
            String input = scanner.nextLine();
            // TODO: 예외 처리
            validInput(input);
            return input;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return startMessage();
        }
    }

    private void validInput(String input) {
        Matcher m = Pattern.compile("//(.)(\\n)(.*)").matcher(input);
        System.out.println("asd" + m.find());
        System.out.println(m.group(0));
        System.out.println(m.group(1));
        if (!m.find()) {
            throw new RuntimeException("유효한 입력이 아닙니다.");
        }
    }
}
