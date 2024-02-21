package ladder.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class InputView {
    private static final String INPUT_NAME_DESCRIPTION = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static List<String> inputPlayerNames() throws IOException {
        System.out.println(INPUT_NAME_DESCRIPTION);
        String rawNames = br.readLine();

        return List.of(rawNames.split(","));
    }
}
