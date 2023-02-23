package laddergame.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public List<String> readNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return Arrays.stream(readLine().split("\\s*,\\s*")).collect(Collectors.toList());
    }

    public int readHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(readLine());
    }

    public List<String> readResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return Arrays.stream(readLine().split("\\s*,\\s*")).collect(Collectors.toList());
    }

    public String readNameToCheckResult() {
        System.out.println("결과를 보고 싶은 사람은?");
        return readLine();
    }

    private String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new IllegalStateException("문자열을 읽을 때 예외가 발생했습니다.", e);
        }
    }
}
