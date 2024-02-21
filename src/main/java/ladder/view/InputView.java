package ladder.view;

import java.util.List;
import ladder.view.model.Reader;

public class InputView {

    private static final String SPLIT_DELIMITER = ",";
    private final Reader consoleReader;

    public InputView(Reader consoleReader) {
        this.consoleReader = consoleReader;
    }

    public List<String> getNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요");
        return divideInput();
    }

    public String getHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return consoleReader.readLine();
    }

    private List<String> divideInput() {
        return List.of(consoleReader.readLine().split(SPLIT_DELIMITER));
    }
}
