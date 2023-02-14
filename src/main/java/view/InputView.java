package view;

import model.LadderHeight;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String SPLIT_DELIMITER = ",";
    private Scanner scanner = new Scanner(System.in);

    public List<String> readPlayerNames(){
        String names = scanner.nextLine();
        return splitPlayerNames(names);
    }

    private List<String> splitPlayerNames(String names){
        return Arrays.asList(names.split(SPLIT_DELIMITER));
    }

    public LadderHeight readLadderHeight(){
        LadderHeight height = new LadderHeight(scanner.nextInt());
        return height;
    }
}
