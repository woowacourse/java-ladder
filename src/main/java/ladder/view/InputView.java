package ladder.view;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER = ",";

    private InputView(){}

    public static List<String> inputUserNames(){
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return List.of(splitInput());
    }

    public static int inputFloorHeight(){
        try{
            System.out.println("최대 사다리 높이는 몇 개인가요?");
           return scanner.nextInt();
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("층수는 숫자를 입력해야 합니다.");
        }
    }

    private static String[] splitInput() {
        return scanner.nextLine().split(DELIMITER);
    }
}
