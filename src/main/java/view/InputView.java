package view;

import domain.vo.*;
import validator.InputValidator;
import validator.dto.InputValidationRequest;
import validator.type.ValidateType;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_LADDER_HEIGHT_MESSAGE = "\n최대 사다리 높이는 몇 개인가요?";
    private static final String NAME_DELIMITER = ",";
    private static final String INPUT_RESULTS_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_RESULT_VIEWER_NAME_MESSAGE = "결과를 보고 싶은 사람은?";

    private final InputValidator validator;
    private final Scanner scanner = new Scanner(System.in);

    public InputView(InputValidator inputValidator) {
        this.validator = inputValidator;
    }

    public Names inputNames() {
        System.out.println(INPUT_NAMES_MESSAGE);
        List<String> names = List.of(scanner.nextLine().split(NAME_DELIMITER));
        validateNames(names);
        return new Names(mapToName(trimNames(names)));
    }

    public Results inputResults() {
        System.out.println(INPUT_RESULTS_MESSAGE);
        List<String> results = List.of(scanner.nextLine().split(NAME_DELIMITER));
        // TODO:validateResults(results);
        return new Results(mapToResult(results));
    }

    public Names inputResultViewerName() {
        System.out.println(INPUT_RESULT_VIEWER_NAME_MESSAGE);
        List<String> names = List.of(scanner.nextLine().split(NAME_DELIMITER));
        // TODO:validate
        return new Names(mapToName(names));
    }

    private void validateNames(final List<String> names) {
        for (String name : names) {
            validator.validate(
                    new InputValidationRequest(
                            List.of(ValidateType.DUPLICATE_VALUE),
                            name
                    )
            );
        }
    }

    private List<String> trimNames(List<String> names) {
        return names.stream()
                .map(String::trim)
                .collect(Collectors.toUnmodifiableList());
    }

    public Height inputLadderHeight() {
        System.out.println(INPUT_LADDER_HEIGHT_MESSAGE);
        String input = scanner.nextLine();
        validator.validate(
                new InputValidationRequest(
                        List.of(ValidateType.EMPTY_VALUE, ValidateType.INTEGER_VALUE),
                        input
                )
        );
        return new Height(Integer.parseInt(input));
    }

    public List<Result> mapToResult(List<String> result) {
        return result.stream()
                .map(Result::new)
                .collect(Collectors.toList());
    }

    public List<Name> mapToName(List<String> names) {
        return names.stream()
                .map(Name::new)
                .collect(Collectors.toList());
    }
}
