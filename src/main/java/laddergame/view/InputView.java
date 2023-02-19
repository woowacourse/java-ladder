package laddergame.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String NAMES_SPLIT_REGEX = "\\s*,\\s*";
    private static final String READER_EXCEPTION = "입력중 오류가 발생하였습니다.";
    private static final String HEIGHT_INPUT_NUMBER_EXCEPTION = "높이는 숫자만 들어올 수 있습니다.";
    private static final String ANNOUNCE_READ_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String ANNOUNCE_READ_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public List<String> readNames() {
        System.out.println(ANNOUNCE_READ_NAMES);
        try {
            return Arrays.stream(reader.readLine().split(NAMES_SPLIT_REGEX))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new UncheckedIOException(READER_EXCEPTION, e);
        }
    }

    public int readHeight() {
        System.out.println(ANNOUNCE_READ_HEIGHT);
        try {
            String inputHeight = reader.readLine();
            validateInt(inputHeight);
            return Integer.parseInt(inputHeight);
        } catch (IOException e) {
            throw new UncheckedIOException(READER_EXCEPTION, e);
        }
    }

    private void validateInt(final String inputHeight) {
        try {
            Integer.parseInt(inputHeight);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(HEIGHT_INPUT_NUMBER_EXCEPTION);
        }
    }
}
