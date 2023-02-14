package view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_USER_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";

    static Scanner sc = new Scanner(System.in);

    public static String inputUserName() {
        System.out.println(INPUT_USER_NAME);
        return sc.next();
    }
}
