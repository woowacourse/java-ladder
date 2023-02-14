package ui.input;

import java.util.Scanner;

/**
 * @author 최원용
 * @version 2.0.0
 * @Created by 최원용 on 2023. 02. 14.
 */
public class InputView {

    private static final Scanner sc = new Scanner(System.in);
    private static final String INPUT_PEOPLES_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";

    public static String getPeoplesName() {
        System.out.println(INPUT_PEOPLES_NAME);
        return sc.next();
    }
}
