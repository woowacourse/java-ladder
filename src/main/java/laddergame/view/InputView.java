package laddergame.view;

import laddergame.domain.*;

import java.util.Scanner;

public class InputView {
    private static Scanner reader = new Scanner(System.in);

    public static PlayerGroup askUserNames() {
        System.out.println("참여할 사람의 이름을 입력하세요. 이름은 쉼표로 구분하세요!");

        try {
            return PlayersGenerator.createPlayers(reader.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return askUserNames();
        }
    }

    public static int askHeight(int width) {
        System.out.println("사다리 높이는 몇 개인가요?");

        String height = reader.nextLine();

        try {
            LadderValidator.validateLadder(height);
            return Integer.parseInt(height);
        } catch (NullPointerException e) {
            System.out.println("사다리의 높이가 입력되지 않았습니다.");
            return askHeight(width);
        } catch (NumberFormatException e) {
            System.out.println("사다리의 높이는 자연수여야 합니다.\n다시 입력해주세요.");
            return askHeight(width);
        } catch (IllegalArgumentException e) {
            System.out.println("사다리의 높이는 최소 1이상이어야 합니다.\n다시 입력해주세요.");
            return askHeight(width);
        }
        /*try {
            return new Ladder(width, reader.nextLine());
        } catch (NullPointerException e) {
            System.out.println("사다리의 높이가 입력되지 않았습니다.");
            return askHeight(width);
        } catch (NumberFormatException e) {
            System.out.println("사다리의 높이는 자연수여야 합니다.\n다시 입력해주세요.");
            return askHeight(width);
        } catch (IllegalArgumentException e) {
            System.out.println("사다리의 높이는 최소 1이상이어야 합니다.\n다시 입력해주세요.");
            return askHeight(width);
        }*/
    }

    public static PrizeGroup askPrizes(int countOfPlayers) {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요.)");

        try {
            return PrizesGenerator.createPrizes(reader.nextLine(), countOfPlayers);
        } catch (IllegalArgumentException e) {
            System.out.println("상품의 수가 올바르지 않습니다.\n다시 입력하세요.");
            return askPrizes(countOfPlayers);
        }
    }

    public static Player askResult() {
        System.out.println("결과를 보고 싶은 사람은 ?");

        return new Player(new PlayerName(reader.nextLine()));
    }
}
