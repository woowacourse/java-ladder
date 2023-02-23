package laddergame.view;

import laddergame.domain.Target;
import laddergame.util.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER = ",";


    public List<String> readUserNames() {
        String inputUserNames = scanner.nextLine();
        Validator.checkNull(inputUserNames);
        return splitByDelimiter(inputUserNames);
    }

    public String readHeight() {
        String inputHeight = scanner.nextLine();
        Validator.checkNull(inputHeight);
        return inputHeight;
    }

    public List<String> readRewards() {
        String inputReward = scanner.nextLine();
        Validator.checkNull(inputReward);
        return splitByDelimiter(inputReward);
    }

    public String readTarget() {
        String inputTarget = scanner.nextLine();
        Validator.checkNull(inputTarget);
        return inputTarget;
    }

    private List<String> splitByDelimiter(String str) {
        return Arrays.asList(str.split(DELIMITER));
    }
}
