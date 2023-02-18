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
        return new Names(scanner.nextLine());
    }

    public LadderHeight readLadderHeight(){
        return new LadderHeight(scanner.nextInt());
    }
}
