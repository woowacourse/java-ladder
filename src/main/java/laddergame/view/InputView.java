package laddergame.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static laddergame.messsages.ViewMessages.ANNOUNCE_READ_HEIGHT;
import static laddergame.messsages.ViewMessages.ANNOUNCE_READ_NAMES;

public class InputView {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public List<String> readNames() {
        System.out.println(ANNOUNCE_READ_NAMES.getMessage());
        try {
            return Arrays.stream(reader.readLine().split("\\s*,\\s*"))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int readHeight() {
        System.out.println(ANNOUNCE_READ_HEIGHT.getMessage());
        try {
            return Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
