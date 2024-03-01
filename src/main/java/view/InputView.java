package view;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Height;
import model.Name;
import model.Participant;
import model.Position;
import model.Result;
import model.Results;

public class InputView {

    private static final String INPUT_PARTICIPANT_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_GAME_RESULT = "\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_LADDER_HEIGHT = "\n최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_PARTICIPANT_NAME_FOR_RESULT = "\n결과를 보고 싶은 사람은?";
    private static final String NULL_EMPTY_INPUT = "입력이 null이거나 빈 문자열 일 수 없습니다.";
    private static final String NOT_NUMERIC_INPUT = "입력이 숫자로 구성되어 있지 않습니다.";
    private static final String DELIMITER = ",";
    private static final Pattern NUMERIC_PATTERN = Pattern.compile("^[0-9]*$");
    private static final Scanner in = new Scanner(System.in);

    public List<Participant> inputParticipantsName() {
        System.out.println(INPUT_PARTICIPANT_NAMES);
        String input = in.nextLine();
        validateNotNullAndBlank(input);
        List<String> names = splitInputByDelimiter(input, DELIMITER);
        return IntStream.range(0, names.size())
                .mapToObj(position -> new Participant(new Name(names.get(position)), new Position(position)))
                .toList();
    }

    public List<Result> inputResults() {
        System.out.println(INPUT_GAME_RESULT);
        String input = in.nextLine();
        validateNotNullAndBlank(input);
        List<String> results = splitInputByDelimiter(input, DELIMITER);
        return IntStream.range(0, results.size())
                .mapToObj(index -> new Result(new Position(index), results.get(index)))
                .toList();
    }
    private List<String> splitInputByDelimiter(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter))
                .map(String::trim)
                .toList();
    }

    private void validateNotNullAndBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(NULL_EMPTY_INPUT);
        }
    }

    public int inputLadderHeight() {
        System.out.println(INPUT_LADDER_HEIGHT);
        String input = in.nextLine();
        validateNotNullAndBlank(input);
        validateNumeric(input);
        return Integer.parseInt(input);
    }

    private void validateNumeric(String input) {
        if (!NUMERIC_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(NOT_NUMERIC_INPUT);
        }
    }

    public String inputParticipantNameForResult() {
        System.out.println(INPUT_PARTICIPANT_NAME_FOR_RESULT);
        String input = in.nextLine();
        validateNotNullAndBlank(input);
        return input;
    }
}
