/*
 * @(#)InputView.java      1.0 2019/05/16
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Ladder, Java, Seoul, KOREA
 */

package ladder.view;

import ladder.model.ladder.Floor;

import java.util.Scanner;

/**
 * @version 1.0 2019년 05년 16일
 * @author 김효건
 */
public class InputView {
    /*사다리게임의 입력에 대한 클래스*/
    private static final String INPUT_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_FLOORS_MESSAGE = "최대 사다리 높이는 몇 개인가요";
    private static final String INPUT_RESULTS_MESSAGE = "실행결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_SELECT_RESULTS_MESSAGE = "결과를 보고 싶은 사람은? (종료를 원하시면 exit을 입력하세요)";
    private static Scanner scanner = new Scanner(System.in);

    public static String inputPlayers() {
        System.out.println(INPUT_NAMES_MESSAGE);
        return scanner.nextLine();
    }

    public static String inputResults() {
        System.out.println(INPUT_RESULTS_MESSAGE);
        return scanner.nextLine();
    }

    public static Floor inputFloors() {
        System.out.println(INPUT_FLOORS_MESSAGE);
        return new Floor(scanner.nextLine());
    }

    public static String inputChoice() {
        System.out.println(INPUT_SELECT_RESULTS_MESSAGE);
        return scanner.nextLine();
    }
}
