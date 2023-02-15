import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String USER_NAME_INPUT_GUIDE_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDERS_HEIGHT_INPUT_GUIDE_MESSAGE = "\n최대 사다리 높이는 몇 개인가요?";
    private static final Scanner sc = new Scanner(System.in);

    public List<String> inputUsername() {
        System.out.println(USER_NAME_INPUT_GUIDE_MESSAGE);
        return Arrays.asList(sc.nextLine().split(",",-1));
    }

    public int inputLadderHeight() {
        try {
            System.out.println(LADDERS_HEIGHT_INPUT_GUIDE_MESSAGE);
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("사다리 높이는 정수만 입력가능합니다.");
        }
    }
}
