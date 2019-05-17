package ladderGame.view;

import ladderGame.model.input.PlayerNamesInput;
import ladderGame.model.input.ResultsInput;
import ladderGame.model.input.RowInput;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String STRING_SEPERATOR = ",";
    private static final String ASK_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String ASK_RESULTS ="\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String ASK_ROWS = "\n최대 사다리 높이는 몇 개인가요?";
    private static final String ASK_PLAYER = "\n결과를 보고 싶은 사람은?";

    public static PlayerNamesInput readNames() {
        System.out.println(ASK_NAMES);
        try {
            PlayerNamesInput playerNamesInput = new PlayerNamesInput(scanner.nextLine());
            return playerNamesInput;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return readNames();
        }
    }

    public static ResultsInput readResults(PlayerNamesInput playerNamesInput) {
        System.out.println(ASK_RESULTS);
        try {
            ResultsInput resultsInput = new ResultsInput(scanner.nextLine(), playerNamesInput);
            return resultsInput;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return readResults(playerNamesInput);
        }
    }

    public static int readRows() {
        System.out.println(ASK_ROWS);
        try {
            RowInput rowInput = new RowInput(scanner.nextLine());
            return rowInput.getRow();
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return readRows();
        }
    }

    public static String readPlayer(PlayerNamesInput playerNamesInput) {
        System.out.println(ASK_PLAYER);
        String name = scanner.nextLine().trim();

        if (playerNamesInput.getNames().contains(name) || name.equals("all") || name.equals("quit")) {
            return name;
        }
        System.out.println("전 이름들 입력에 속한 이름 혹은 all 혹은 quit을 입력해야 합니다.");
        return readPlayer(playerNamesInput);
    }
}
