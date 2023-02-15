package laddergame.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class InputView {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static List<String> readNames() {
        try {
            final String[] names = bufferedReader.readLine().split(",");
            return Arrays.asList(names);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int readFloor() {
        try {
            return Integer.parseInt(bufferedReader.readLine());
        } catch (IOException | NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }
}
