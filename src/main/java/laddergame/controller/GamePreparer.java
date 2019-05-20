package laddergame.controller;

import laddergame.domain.Tags;
import laddergame.util.InputView;
import laddergame.util.Splitter;
import laddergame.validator.InputValidator;

import java.util.List;

public class GamePreparer {
    public static Tags makeMembers() {
        try {
            String inputNames = InputView.inputMembers();
            InputValidator.checkEndsWithComma(inputNames);
            List<String> names = Splitter.splitByComma(inputNames);

            InputValidator.checkMemberNames(names);
            return new Tags(names);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return makeMembers();
        }
    }

    public static Tags makePrizes(final int size) {
        try {
            String inputNames = InputView.inputPrizes();
            InputValidator.checkEndsWithComma(inputNames);
            List<String> names = Splitter.splitByComma(inputNames);

            InputValidator.checkPrizesName(names, size);
            return new Tags(names);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return makePrizes(size);
        }
    }

    public static int makeHeight() {
        try {
            int height = InputView.inputHeight();
            InputValidator.checkHeightIsPositive(height);
            return height;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return makeHeight();
        }
    }
}
