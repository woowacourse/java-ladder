package laddergame.view;

import java.util.Scanner;

public class InputView {
    private static Scanner reader = new Scanner(System.in);

    public static String askUserNames() {
        System.out.println("참여할 사람의 이름을 입력하세요. 이름은 쉼표로 구분하세요!");
        return reader.nextLine();
    }

    public static int askHeight() {
        System.out.println("사다리 높이는 몇 개인가요?");
        return reader.nextInt();
    }
}
