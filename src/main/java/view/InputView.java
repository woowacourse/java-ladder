package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputView implements AutoCloseable {
    public static final String ENTIRE_PARTICIPANTS = "all";

    private static final String INPUT_PARTICIPANT_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_RESULT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_PARTICIPANT_NAME = "결과를 보고 싶은 사람은?";
    private static final String NULL_EMPTY_INPUT = "입력이 null이거나 빈 문자열 일 수 없습니다.";
    private static final String NOT_NUMERIC_INPUT = "입력이 숫자로 구성되어 있지 않습니다.";
    private static final String DELIMITER = ",";
    private static final Pattern NUMERIC_PATTERN = Pattern.compile("^[0-9]*$");

    private final BufferedReader reader;

    public InputView() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private String readLine(){
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> inputParticipantsName() {
        System.out.println(INPUT_PARTICIPANT_NAMES);
        String input = readLine();
        validateNotNullAndBlank(input);
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .toList();
    }

    private void validateNotNullAndBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(NULL_EMPTY_INPUT);
        }
    }

    public int inputLadderHeight() {
        System.out.println(System.lineSeparator() + INPUT_LADDER_HEIGHT);
        String input = readLine();
        validateNotNullAndBlank(input);
        validateNumeric(input);
        return Integer.parseInt(input);
    }

    private void validateNumeric(String input) {
        if (!NUMERIC_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(NOT_NUMERIC_INPUT);
        }
    }

    public List<String> inputResults() {
        System.out.println(System.lineSeparator() + INPUT_RESULT);
        String input = readLine();
        validateNotNullAndBlank(input);
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .toList();
    }

    public String inputParticipantName() {
        System.out.println(System.lineSeparator() + INPUT_PARTICIPANT_NAME);
        String input = readLine();
        validateNotNullAndBlank(input);
        return input;
    }

    @Override
    public void close() throws Exception {
        reader.close();
    }


}
