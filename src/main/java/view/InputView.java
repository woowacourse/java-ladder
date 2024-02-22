package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String[] readNames() throws IOException {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return br.readLine().split(",");
    }

    public static int readHeight() throws IOException {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(br.readLine());
    }
}
