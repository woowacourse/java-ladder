package ladder.view;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String SPLIT_DELIMITER = ",";
    private static final String KEEP_CHECK = "Y";
    private static final String STOP_CHECK = "N";

    private final Scanner scanner;

    public InputView(InputStream in) {
        this.scanner = new Scanner(in);
    }

    public List<String> getNames() {
        System.out.println("\n참여할 사람 이름을 입력하세요. (이름은 쉼표(" + SPLIT_DELIMITER + ")로 구분하세요");
        return divideInput();
    }

    public String getHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        return scanner.nextLine();
    }

    public List<String> getPrizes() {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(" + SPLIT_DELIMITER + ")로 구분하세요)");
        return divideInput();
    }

    public String getEndOrNotChoice() {
        System.out.println("\n결과를 확인할 경우 " + KEEP_CHECK + " 끝낼 경우 " + STOP_CHECK + "를 입력해주세요.");
        return scanner.nextLine();
    }

    public String getSeeResultParticipant() {
        System.out.println("\n결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }

    private List<String> divideInput() {
        return List.of(scanner.nextLine().split(SPLIT_DELIMITER));
    }
}
