package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final String SEPERATOR = ",";

    public static List<String> readNames() throws IOException {
        System.out.printf("참여할 사람 이름을 입력하세요. (이름은 쉼표(%s)로 구분하세요)%n", SEPERATOR);

        String[] splitInput = br.readLine().split(SEPERATOR);
        return Arrays.stream(splitInput)
                .map(String::trim)
                .toList();
    }

    public static int readHeight() throws IOException {
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        return Integer.parseInt(br.readLine());
    }
}
