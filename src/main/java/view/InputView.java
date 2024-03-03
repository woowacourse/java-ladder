package view;

import java.io.BufferedReader;
import java.io.IOException;

public class InputView {
    private static final String NAMES_INPUT = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_RESULT_INPUT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String SEARCH_NAME_INPUT = "결과를 보고 싶은 사람은?";
    private static final String HEIGHT_INPUT = "최대 사다리 높이는 몇 개인가요?";
    private final BufferedReader bufferedReader;

    public InputView(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public String getSearchNameFromConsole() {
        System.out.println(SEARCH_NAME_INPUT);
        return getInput();
    }

    public String getNamesInputFromConsole() {
        System.out.println(NAMES_INPUT);
        return getInput();
    }

    public String getLadderResultsFromConsole() {
        System.out.println(LADDER_RESULT_INPUT);
        return getInput();
    }

    public int getHeightInputFromConsole() {
        System.out.println(HEIGHT_INPUT);
        return Integer.parseInt(getInput());

    }

    private String getInput() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
