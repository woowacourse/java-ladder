package view;

import domain.Players;

import java.util.List;

public class OutputView {

    public static final String BOTH_ENDS_FORMAT = "%-5s";
    public static final String MIDDLE_FORMAT = "%6s";

    public void printNames(Players players) {
        List<String> names = players.getPlayersName();
        for (int i = 0; i < names.size(); i++) {
            firstPlayerPrint(names, i);
            lastPlayerPrint(names, i);
            middlePlayersPrint(names, i);
        }
    }

    private void firstPlayerPrint(List<String> names, int i) {
        if (i == 0) {
            System.out.print(String.format(BOTH_ENDS_FORMAT, names.get(i)));
        }
    }

    private void lastPlayerPrint(List<String> names, int i) {
        if (i == names.size() - 1) {
            System.out.print(String.format(BOTH_ENDS_FORMAT, names.get(i)));
        }
    }

    private static void middlePlayersPrint(List<String> names, int i) {
        if (0 < i && i < names.size() - 1) {
            System.out.print(String.format(MIDDLE_FORMAT, names.get(i)));
        }
    }

}
