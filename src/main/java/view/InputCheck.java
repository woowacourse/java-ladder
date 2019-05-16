package view;

import util.StringUtil;

public class InputCheck {

    public static boolean checkResultSize(String input, int userSize) {
        return StringUtil.splitComma(input).size() == userSize;
    }
}
