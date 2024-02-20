package view;

import java.util.Scanner;

public class InputView {
    private final Scanner sc;

    public InputView(Scanner sc) {
        this.sc = sc;
    }

    public String readPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return sc.nextLine();
    }
}
