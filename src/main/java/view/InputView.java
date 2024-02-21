package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public List<String> readPlayerNames() {
        try {
            String input = bufferedReader.readLine();
            String removedInput = removeBlank(input);
            return split(removedInput);
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }

    public int readHeight() {
        try {
            String input = bufferedReader.readLine();
            return Integer.parseInt(input);
        } catch (NumberFormatException | IOException e) {
            throw new IllegalArgumentException("높이는 최소 2이상, 최대 10이하의 숫자만 가능합니다.");
        }
    }

    private String removeBlank(String input) {
        return input.replaceAll(" ", "");
    }

    private List<String> split(String input) {
        return Arrays.asList(input.split(","));
    }
}
