package ladder.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static List<String> readNames(String separator) throws IOException {
        String[] splitInput = reader.readLine().split(separator);

        return Arrays.stream(splitInput)
                .map(String::trim)
                .toList();
    }

    public static int readHeight() throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    public static String readNameForResult() throws IOException {
        return reader.readLine().trim();
    }
}
