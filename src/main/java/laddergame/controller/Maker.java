package laddergame.controller;

import laddergame.domain.Tags;
import laddergame.util.InputView;
import laddergame.util.OutputView;
import laddergame.util.Spliter;
import laddergame.util.Validator;

import java.util.List;

public class Maker {
    private static final String INPUT_MEMBERS = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_PRIZES = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";

    public static Tags makeMembers() {
        try {
            OutputView.outputMessage(INPUT_MEMBERS);
            List<String> names = Spliter.splitByComma(InputView.inputNames());
            Validator.checkEmptyTag(names);
            Validator.checkDuplicateNames(names);
            return new Tags(names);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return makeMembers();
        }
    }

    public static Tags makePrizes(int size) {
        try {
            OutputView.outputMessage(INPUT_PRIZES);
            List<String> names = Spliter.splitByComma(InputView.inputNames());
            Validator.checkEmptyTag(names);
            Validator.checkEqualSize(size, names.size());
            return new Tags(names);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return makePrizes(size);
        }
    }
}
