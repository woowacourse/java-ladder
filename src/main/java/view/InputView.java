package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String NAME_INPUT_NOTICE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String DELIMITER = ",";
    private static final String LADDER_HEIGHT_INPUT_NOTICE = "\n최대 사다리 높이는 몇 개인가요?";
    private static final String RESULT_INPUT_NOTICE = "\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String NUMBER_ERROR = "[ERROR] 숫자를 입력해야합니다.";
    private static final String TARGET_PLAYER_NOTICE = "\n결과를 보고 싶은 사람은?";

    public List<String> readPlayersName(){
        System.out.println(NAME_INPUT_NOTICE);
        String[] names = readInput().split(DELIMITER);
        return Arrays.asList(names);
    }

    private String readInput(){
        return scanner.nextLine();
    }

    public int readLadderHeight(){
        System.out.println(LADDER_HEIGHT_INPUT_NOTICE);
        try {
            return Integer.parseInt(scanner.next());
        }catch (NumberFormatException exception){
            throw new IllegalArgumentException(NUMBER_ERROR);
        }
    }

    public List<String> readResults() {
        System.out.println(RESULT_INPUT_NOTICE);
        String[] results = readInput().split(DELIMITER);
        return Arrays.asList(results);
    }

    public String readTargetPlayer() {
        System.out.println(TARGET_PLAYER_NOTICE);
        scanner.nextLine();
        return readInput();
    }
}
