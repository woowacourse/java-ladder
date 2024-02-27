package view;

import utils.Console;

import java.util.List;

public class InputView {
    private static final String DELIMITER = ",";

    public List<String> askParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] participants = Console.readLine().split(DELIMITER, -1);
        return List.of(participants);
    }

    public String askLadderHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        return Console.readLine();
    }

}
