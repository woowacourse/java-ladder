package laddergame.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public InputView() {
    }

    public List<String> readPlayersName() {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        try {
            return Arrays.stream(bufferedReader.readLine().split(","))
                    .map(String::trim)
                    .toList();
        } catch (IOException exception) {
            throw new IllegalArgumentException();
        }

    }

    public int readLadderHeight() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        try {
            return Integer.parseInt(bufferedReader.readLine());
        } catch (IOException exception) {
            throw new IllegalArgumentException();
        }
    }
}
