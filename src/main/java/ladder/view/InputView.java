package ladder.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static String inputNames(){
        try{
            return SCANNER.nextLine();
        }catch (Exception e){
            return inputNames();
        }
    }

    public static int inputHeight(){
        try{
            return SCANNER.nextInt();
        }catch (Exception e){
            return inputHeight();
        }
    }
}
