package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static List<String> readNames(String SEPARATOR) throws IOException {
        String[] splitInput = br.readLine().split(SEPARATOR);

        return Arrays.stream(splitInput)
                .map(String::trim)
                .toList();
    }

    public static int readHeight() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    public static String readNameForResult() throws IOException {
        return br.readLine();
    }
}
