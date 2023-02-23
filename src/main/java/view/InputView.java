package view;

import java.util.List;
import java.util.Scanner;
import validator.InputValidatorChain;
import validator.dto.InputValidationRequest;
import validator.type.ValidateType;

public class InputView {

    private static final String INPUT_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_LADDER_HEIGHT_MESSAGE = "\n최대 사다리 높이는 몇 개인가요?";
    private static final String DELIMITER = ",";
    public static final String INPUT_RESULT_MESSAGE = "\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    public static final String INPUT_RESULT_TARGET_MESSAGE = "\n결과를 보고 싶은 사람은?";
    private final InputValidatorChain validator;
    private final Scanner scanner = new Scanner(System.in);

    public InputView(InputValidatorChain inputValidator) {
        this.validator = inputValidator;
    }

    public List<String> inputNames() {
        return getInputs(INPUT_NAMES_MESSAGE, List.of(ValidateType.EMPTY_VALUE));
    }

    public int inputLadderHeight() {
        System.out.println(INPUT_LADDER_HEIGHT_MESSAGE);
        String input = scanner.nextLine();
        validator.validate(new InputValidationRequest(
            List.of(ValidateType.EMPTY_VALUE, ValidateType.INTEGER_VALUE), input));
        return Integer.parseInt(input);
    }

    public List<String> inputResults() {
        return getInputs(INPUT_RESULT_MESSAGE, List.of(ValidateType.EMPTY_VALUE));
    }

    public String inputResultTarget() {
        System.out.println(INPUT_RESULT_TARGET_MESSAGE);
        String input = scanner.nextLine();
        validator.validate(new InputValidationRequest(List.of(ValidateType.EMPTY_VALUE), input));
        return input;
    }

    private List<String> getInputs(String inputResultMessage, List<ValidateType> validateTypes) {
        System.out.println(inputResultMessage);
        String input = scanner.nextLine();
        validator.validate(new InputValidationRequest(validateTypes, input));
        return List.of(input.replace(" ", "").trim().split(DELIMITER));
    }
}
