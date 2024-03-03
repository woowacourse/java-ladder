package view;

import java.util.Scanner;

public class InputView {

    private final static Scanner scanner = new Scanner(System.in);

    public String askParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    public String askLadderHeight() {
        System.out.printf("%n최대 사다리 높이는 몇 개인가요?%n");
        return scanner.nextLine();
    }

    public String askPrizeNames() {
        System.out.printf("%n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)%n");
        return scanner.nextLine();
    }

    public String askForParticipantName() {
        System.out.printf("%n결과를 보고싶은 사람은?%n");
        return scanner.nextLine();
    }
}
