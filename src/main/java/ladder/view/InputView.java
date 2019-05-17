package ladder.view;

import ladder.model.generator.MemberGenerator;
import ladder.model.validator.MemberValidator;

import java.util.Scanner;

public class InputView {
    private static final String NAME_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String RESULT_INPUT_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String HEIGHT_INPUT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String GET_MEMBER_RESULT_INPUT_MESSAGE = "결과를 보고 싶은 사람은?";
    private static Scanner scanner = new Scanner(System.in);

    public static String[] inputNames() {
        System.out.println(NAME_INPUT_MESSAGE);
        String inputText = scanner.nextLine().trim();
        try {
            MemberValidator.checkSeparator(inputText);
            String[] inputs = MemberGenerator.refineNames(inputText);
            MemberValidator.checkNamesLength(inputs);
            return inputs;
        } catch (IllegalArgumentException e) {
            return inputNames();
        }
    }

    public static String[] inputResults(int countOfMember){
        System.out.println(RESULT_INPUT_MESSAGE);
        String inputText = scanner.nextLine().trim();
        try {
            MemberValidator.checkSeparator(inputText);
            String[] inputs = MemberGenerator.refineNames(inputText);
            MemberValidator.checkNamesLength(inputs);
            MemberValidator.checkMemberCount(inputs.length, countOfMember);
            return inputs;
        } catch (IllegalArgumentException e) {
            return inputResults(countOfMember);
        }
    }

    public static int inputLadderHeight(){
        System.out.println(HEIGHT_INPUT_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String inputGetMemberResult(){
        System.out.println(GET_MEMBER_RESULT_INPUT_MESSAGE);
        return scanner.nextLine();
    }
}
