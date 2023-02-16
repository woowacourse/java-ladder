package laddergame.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static List<String> readNames() {
        try {
            System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            final String[] names = bufferedReader.readLine().split(",");
            return Arrays.asList(names);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int readFloor() {
        try {
            System.out.println("최대 사다리 높이는 몇 개인가요?");
            return Integer.parseInt(bufferedReader.readLine());
        } catch (IOException | NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }
}
