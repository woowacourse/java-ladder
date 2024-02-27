package ladder.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private ConsoleReader() {
    }

    public static String readLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException("입력 받는 중 예외가 발생했습니다.");
        }
    }
}
