package laddergame.view;

import java.util.Scanner;

public class InputView {
    private static Scanner reader = new Scanner(System.in);

    public static String askUserNames() {
        System.out.println("참여할 사람의 이름을 입력하세요. 이름은 쉼표로 구부하세요!");
        return reader.nextLine();
    }
}
