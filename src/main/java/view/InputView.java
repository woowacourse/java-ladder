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

    public List<String> askConsequences(){
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String[] consequences= Console.readLine().split(DELIMITER,-1);
        return List.of(consequences);
    }

    public String askChosen(){
        System.out.println("\n결과를 보고 싶은 사람은?");
        return Console.readLine();
    }
}
