package view;

import utils.ScannerUtil;

import java.util.List;

public class InputView {

    public static List<String> inputName() {

        String input = ScannerUtil.nextLine();

        return List.of(input.split(","));
    }

    public static int inputMaxLadderHeight() {

        return ScannerUtil.nextInt();
    }
}
