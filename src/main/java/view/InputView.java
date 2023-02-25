package view;

import model.vo.LadderHeight;
import model.vo.Name;
import model.vo.Result;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String DUPLICATED_NAME_ERROR = "[ERROR] 참가자 이름은 중복될 수 없습니다.";
    private static final String WRONG_SIZE_RESULTS_ERROR = "[ERROR] 사다리 게임 결과 값의 개수는 전체 사람의 수와 동일해야 합니다.";
    private static final String INPUT_DELIMITER = ",";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<Name> readPlayerNames() {
        return createNames(scanner.nextLine());
    }

    public LadderHeight readLadderHeight() {
        return new LadderHeight(Integer.parseInt(scanner.nextLine()));
    }

    public List<Result> readResults(int playerCount) {
        return createResults(playerCount, scanner.nextLine());
    }

    public Name readDesirousResultName() {
        return new Name(scanner.nextLine());
    }

    private List<Name> createNames(String inputNames) {
        List<String> names = splitByDelimiter(inputNames);
        validateDuplicatedNames(names);
        return names.stream()
                .map(Name::new)
                .collect(Collectors.toList());
    }

    private List<Result> createResults(int playersSize, String inputResults) {
        List<String> results = splitByDelimiter(inputResults);
        validateResultsSize(playersSize, results);
        return results.stream()
                .map(Result::new)
                .collect(Collectors.toList());
    }

    private List<String> splitByDelimiter(String inputNames) {
        return Arrays.stream(inputNames.split(INPUT_DELIMITER))
                .map(String::strip)
                .collect(Collectors.toList());
    }

    private void validateDuplicatedNames(List<String> names) {
        if (names.size() != getDistinctCount(names)) {
            throw new IllegalArgumentException(DUPLICATED_NAME_ERROR);
        }
    }

    private void validateResultsSize(int playersSize, List<String> results) {
        if (results.size() != playersSize) {
            throw new IllegalArgumentException(WRONG_SIZE_RESULTS_ERROR);
        }
    }

    private int getDistinctCount(List<String> names) {
        return (int) names.stream()
                .distinct()
                .count();
    }
}
