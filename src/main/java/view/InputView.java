package view;

import model.LadderHeight;
import util.ExceptionMessage;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String SPLIT_DELIMITER = ",";
    private Scanner scanner;

    public InputView(Scanner scanner){
        this.scanner = scanner;
    }

    public List<String> readPlayerNames(){
        String names = scanner.nextLine();
        return splitPlayerNames(names);
    }

    private List<String> splitPlayerNames(String names){
        return Arrays.asList(names.split(SPLIT_DELIMITER));
    }

    public LadderHeight readLadderHeight(){
        try {
            LadderHeight height = new LadderHeight(Integer.parseInt(scanner.nextLine()));
            return height;
        }catch(Exception e){
            throw new IllegalStateException(ExceptionMessage.EXCEPTION_LADDER_HEIGHT.getExceptionMessage());
        }
    }
}
