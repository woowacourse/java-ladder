package laddergame.controller;

import laddergame.domain.Tags;
import laddergame.util.InputView;
import laddergame.util.Splitter;
import laddergame.util.Validator;

import java.util.List;

public class GamePreparer {
    public static Tags makeMembers() {
        try {
            String inputNames = InputView.inputMembers();
            Validator.checkEndsWithComma(inputNames);
            List<String> names = Splitter.splitByComma(inputNames);

            Validator.checkMemberNames(names);
            return new Tags(names);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return makeMembers();
        }
    }

    public static Tags makePrizes(int size) {
        try {
            String inputNames = InputView.inputPrizes();
            Validator.checkEndsWithComma(inputNames);
            List<String> names = Splitter.splitByComma(inputNames);

            Validator.checkPrizesName(names, size);
            return new Tags(names);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return makePrizes(size);
        }
    }

    public static int makeHeight() {
        try {
            int height = InputView.inputHeight();
            Validator.checkHeightIsPositive(height);
            return height;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return makeHeight();
        }
    }
}
