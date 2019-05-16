/*
 * @(#)InputView.java
 *
 * v 1.0.0
 *
 * 2019.05.16
 *
 * Copyright (c) 2019 MrKwon and men7627.
 * WoowahanTechCamp, Seoul, KOREA
 * All right Reserved
 */

package ladder.view;

import java.util.Scanner;

/**
 * 사용자 입력을 담당하는 View 클래스
 *
 * @author mrkwon
 * @author men7627
 * @version 1.0.0
 */
public class InputView {
    private static final String INPUT_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_FLOORS = "최대 사다리 높이는 몇 개인가요";
    private static final String INPUT_RESULTS = "실행결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_SELECT_RESULTS = "결과를 보고 싶은 사람은? (종료를 원하시면 exit을 입력하세요)";

    private static Scanner scanner = new Scanner(System.in);

    public static String playerNames() {
        System.out.println(INPUT_NAMES);
        return scanner.nextLine();
    }

    public static String floors() {
        System.out.println(INPUT_FLOORS);
        return scanner.nextLine();
    }

    public static String resultNames() {
        System.out.println(INPUT_RESULTS);
        return scanner.nextLine();
    }

    public static String selectResult() {
        System.out.println(INPUT_SELECT_RESULTS);
        return scanner.nextLine();
    }
}
