package ladder.domain;

import ladder.Validator;
import ladder.view.InputView;

import java.util.Arrays;
import java.util.List;

public class LadderGame {
    public static List<String> splitNames(String names) {
        return Arrays.asList(names.split(","));
    }

    public static List<String> getPersonNames() {
        List<String> names;

        do {
            names = LadderGame.splitNames(InputView.inputNames());
        } while (!Validator.checkNamesLength(names));

        return names;
    }

    public static int getLadderHeight() {
        String height;

        do {
            height = InputView.inputHeight();
        } while(!Validator.checkLadderHeight(height));

        return Integer.parseInt(height);
    }
}
