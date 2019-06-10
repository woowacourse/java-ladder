package ladder.view;

import ladder.model.Validator;

import java.util.*;

public class InputView {
    private static final String NAME_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String RESULT_INPUT_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String HEIGHT_INPUT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String FIND_RESULT_MESSAGE = "결과를 보고 싶은 사람은?";
    private static final String NUMBER_EXCEPTION_MESSAGE = "숫자를 입력해주세요.";
    private static final String NUMBER_RANGE_EXCEPTION_MESSAGE = "1 이상의 숫자를 입력해주세요.";
    private static final String SINGLE_BLANK = " ";
    private static final String NONE_BLANK = "";
    public static final String SEPERATOR = ",";
    private static Scanner scanner = new Scanner(System.in);

    public static List<String> inputNames() {
        System.out.println(NAME_INPUT_MESSAGE);
        String inputText = scanner.nextLine().replace(SINGLE_BLANK, NONE_BLANK);
        try {
            Validator.checkInput(inputText);
            return new ArrayList<>(Arrays.asList(inputText.split(SEPERATOR)));
        } catch (IllegalArgumentException e) {
            return inputNames();
        }
    }

    public static List<String> inputResults(int countOfMember){
        System.out.println(RESULT_INPUT_MESSAGE);
        String inputText = scanner.nextLine().replace(SINGLE_BLANK, NONE_BLANK);
        try {
            Validator.checkInput(inputText);
            List<String> inputs = new ArrayList<>(Arrays.asList(inputText.split(SEPERATOR)));
            Validator.checkMemberCount(inputs.size(), countOfMember);
            return inputs;
        } catch (IllegalArgumentException e) {
            return inputResults(countOfMember);
        }
    }

    public static int inputLadderHeight(){
        System.out.println(HEIGHT_INPUT_MESSAGE);
        try {
            int ladderHeight = Integer.parseInt(scanner.nextLine());
            checkLadderHeight(ladderHeight);
            return ladderHeight;
        } catch (InputMismatchException e) {
            System.out.println(NUMBER_EXCEPTION_MESSAGE);
            return inputLadderHeight();
        } catch (IllegalArgumentException e) {
            System.out.println(NUMBER_RANGE_EXCEPTION_MESSAGE);
            return inputLadderHeight();
        }
    }

    private static void checkLadderHeight(int ladderHeight) {
        if (ladderHeight < 1) {
            throw new IllegalArgumentException();
        }
    }

    public static String inputGetMemberResult(){
        System.out.println(FIND_RESULT_MESSAGE);
        return scanner.nextLine().replace(SINGLE_BLANK, NONE_BLANK);
    }
}
