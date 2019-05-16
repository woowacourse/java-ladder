package ladder.view;

import ladder.model.MemberGenerator;
import ladder.model.MemberValidator;

import java.util.Scanner;

public class InputView {
    private static final String NAME_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요";
    private static final String HEIGHT_INPUT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static Scanner scanner = new Scanner(System.in);

    public static String[] inputNames() {
        System.out.println(NAME_INPUT_MESSAGE);
        String inputText = scanner.nextLine().trim();
        try {
            MemberValidator.checkSeparator(inputText);
            String[] names = MemberGenerator.splitByComma(inputText);
            MemberValidator.checkNamesLength(names);
            return names;
        } catch (IllegalArgumentException e) {
            return inputNames();
        }
    }

    public static int inputLadderHeight(){
        System.out.println(HEIGHT_INPUT_MESSAGE);
        return scanner.nextInt();
    }
}
