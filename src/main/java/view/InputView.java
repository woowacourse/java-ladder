package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputView implements AutoCloseable {
    private static final String DELIMITER = ",";

    private final BufferedReader reader;

    public InputView() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public List<String> inputParticipantsName() throws IOException {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = reader.readLine();
        validateNotNullAndBlank(input);
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .toList();
    }

    private void validateNotNullAndBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void close() throws Exception {
        reader.close();
    }
}
