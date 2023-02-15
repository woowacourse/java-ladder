package ladder.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final InputView INSTANCE = new InputView();
    private InputView(){
    }

    public static InputView getInstance() {
        return INSTANCE;
    }


    public List<String> readNames(){
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Scanner scanner = new Scanner(System.in);
        String names = scanner.nextLine();

        return new ArrayList<>(List.of(splitNames(names)));
    }

    private String[] splitNames(String input){
        return input.split(",");
    }


}
