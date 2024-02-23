package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final String USER_NAME_DELIMITER = ",";


    public static String[] readNames() throws IOException {
        printNameInputMessage();
        return removeBlank(reader.readLine()).split(USER_NAME_DELIMITER);
    }

    public static int readHeight() throws IOException {
        printLadderHeightInputMessage();
        return Integer.parseInt(reader.readLine());
    }

    private static void printNameInputMessage() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    private static String removeBlank(final String text) {
        return text.replace(" ", "");
    }

    private static void printLadderHeightInputMessage() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }
}
