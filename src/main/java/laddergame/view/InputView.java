package laddergame.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String NAME_SEPARATOR = ",";
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));

    public static List<String> readNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        try {
            final String[] names = read().split(NAME_SEPARATOR);
            return Arrays.asList(names);
        } catch (IOException e) {
            throw new IllegalStateException("입력값을 받을 수 없습니다.");
        }
    }

    public static int readHeight() {
        System.out.println(System.lineSeparator() + "최대 사다리 높이는 몇 개인가요?");

        try {
            return Integer.parseInt(read());
        } catch (IOException e) {
            throw new IllegalStateException("입력값을 받을 수 없습니다.");
        } catch (NumberFormatException e) {
            throw new IllegalStateException("숫자만 입력해주세요.");
        }
    }

    private static String read() throws IOException {
        return BUFFERED_READER.readLine();
    }
}
