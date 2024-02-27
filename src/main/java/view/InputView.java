package view;

import java.util.Scanner;

public class InputView {

    public String readNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return read();
    }

    public String readResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return read();
    }

    public String readHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return read();
    }

    public String readTargets() {
        System.out.println("결과를 보고 싶은 사람은?");
        return read();
    }

    private String read() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
