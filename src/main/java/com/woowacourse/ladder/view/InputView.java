package com.woowacourse.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_PLAYER_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_EXECUTE_RESULTS_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_RESULT_QUERY_MESSAGE = "결과를 보고 싶은 사람은?";

    public static List<String> promptPlayerNames() {
        System.out.println(INPUT_PLAYER_NAME_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        List<String> names = Arrays.asList(scanner.nextLine().split(","));

        return names;
    }

    public static List<String> promptExecuteResults() {
        System.out.println(INPUT_EXECUTE_RESULTS_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        List<String> results = Arrays.asList(scanner.nextLine().split(","));

        return results;
    }

    public static String promptHeight() {
        System.out.println(INPUT_HEIGHT_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        String height = scanner.nextLine();

        return height;
    }

    public static String promptResultQuery() {
        System.out.println(INPUT_RESULT_QUERY_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        String resultQuery = scanner.nextLine().trim();

        return resultQuery;
    }
}
