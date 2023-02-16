package view;

import model.LadderHeight;
import model.Names;

import java.util.Scanner;

public class InputView {
    private Scanner scanner;

    public InputView(Scanner scanner){
        this.scanner = scanner;
    }

    public Names readPlayerNames(){
        String names = scanner.nextLine();
        return new Names(names);
    }

    public LadderHeight readLadderHeight(){
        LadderHeight height = new LadderHeight(scanner.nextInt());
        return height;
    }
}
