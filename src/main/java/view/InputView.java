package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static List<String> readNames() throws IOException {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        String[] splitInput = br.readLine().split(",");
        return Arrays.stream(splitInput)
                .map(String::trim)
                .toList();
    }

    public static int readHeight() throws IOException {
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        return Integer.parseInt(br.readLine());
    }
}
