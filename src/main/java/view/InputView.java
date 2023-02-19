package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String NAME_INPUT_NOTICE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요";
    private static final String DELIMITER = ",";
    private static final String LADDER_HEIGHT_INPUT_NOTICE = "최대 사다리 높이는 몇 개인가요?";

    private static final String NOT_INTEGER_ERROR = "[ERROR] 숫자가 아닙니다.";

    public List<String> readPersonsName(){
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
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(NOT_INTEGER_ERROR);
        }
    }
}
