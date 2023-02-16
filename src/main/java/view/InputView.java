package view;

import validator.InputValidator;
import validator.dto.InputValidationRequest;
import validator.type.ValidateType;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_LADDER_HEIGHT_MESSAGE = "\n최대 사다리 높이는 몇 개인가요?";
    private static final String NAME_DELIMITER = ",";
    private final InputValidator validator;
    private final Scanner scanner = new Scanner(System.in);

    public InputView(InputValidator inputValidator) {
        this.validator = inputValidator;
    }

    public List<String> inputNames() {
        System.out.println(INPUT_NAMES_MESSAGE);
        return List.of(scanner.nextLine().trim().split(NAME_DELIMITER));
    }

    public int inputLadderHeight() {
        System.out.println(INPUT_LADDER_HEIGHT_MESSAGE);
        String input = scanner.nextLine();
        validator.validate(new InputValidationRequest(List.of(ValidateType.EMPTY_VALUE, ValidateType.INTEGER_VALUE), input));
        return Integer.parseInt(input);
    }
}
