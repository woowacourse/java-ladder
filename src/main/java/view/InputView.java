package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String NAME_INPUT_NOTICE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요";
    private static final String DELIMITER = ",";

    public List<String> readPersonsName(){
        System.out.println(NAME_INPUT_NOTICE);
        String[] names = readInput().split(DELIMITER);
        return Arrays.asList(names);
    }

    public String readInput(){
        return scanner.nextLine();
    }
}
