package view;

import static utils.Console.NEW_LINE;

import utils.Console;

public class InputView {

    public String askParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return Console.readLine();
    }

    public String askLadderHeight() {
        System.out.println(NEW_LINE + "최대 사다리 높이는 몇 개인가요?");
        return Console.readLine();
    }

}
